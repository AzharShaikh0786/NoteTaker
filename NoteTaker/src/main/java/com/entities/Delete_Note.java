package com.entities;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Factory.FactoryProvider;

@WebServlet("/Delete_Note")
public class Delete_Note extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Delete_Note() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Get note_id parameter from request
            String noteIdParam = request.getParameter("note_id");

            // Validate input
            if (noteIdParam == null || noteIdParam.isEmpty()) {
                response.getWriter().write("Error: Note ID is missing or invalid.");
                return;
            }

            // Parse note_id to integer
            int id = Integer.parseInt(noteIdParam);

            // Perform deletion using Hibernate
            Session session = FactoryProvider.provider().openSession();
            NotesTaker notes = session.get(NotesTaker.class, id);

            if (notes != null) {
                Transaction transaction = session.beginTransaction();
                session.delete(notes);
                transaction.commit();
                session.close();

                // Redirect to All Notes page after successful deletion
                response.sendRedirect("All_Notes.jsp");
            } else {
                response.getWriter().write("Error: Note not found for ID " + id);
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("Error: Invalid Note ID format. Please provide a valid numeric ID.");
            e.printStackTrace();
        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Redirect POST requests to doGet for simplicity
    }
}
