package com.entities;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Factory.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Add_Form")
public class Add_Form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add_Form() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			NotesTaker notes = new NotesTaker(title, content, new Date());
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
//			out.println(notes);
			
			//hibernate to save in database;
			
			Session session = FactoryProvider.provider().openSession();
			Transaction transaction = session.beginTransaction();
			session.save(notes);
			transaction.commit();
			session.close();

			out.println("<h1 style='text-align:center;'>Added Succesfully...</h1>");
			out.println("<h1 style='text-align:center;'><a href='All_Notes.jsp'>View Notes</a></h1>");

		} catch (Exception e) {
			System.out.print(e);

		}
	}

}
