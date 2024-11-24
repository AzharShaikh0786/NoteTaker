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

@WebServlet("/Update_Note")
public class Update_Note extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Update_Note() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int id = Integer.parseInt(request.getParameter("id"));
		Session session = FactoryProvider.provider().openSession();
		Transaction transaction = session.beginTransaction();
		NotesTaker note = session.get(NotesTaker.class, id);
		note.setTitle(title);
		note.setContent(content);

		session.save(note);
		transaction.commit();
		session.close();
		response.sendRedirect("All_Notes.jsp");

	}

}
