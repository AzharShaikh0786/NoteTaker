<%@page import="com.entities.NotesTaker"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.Factory.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes: Notes Taker</title>
<%@ include file="All_links.jsp"%>
</head>
<body>

	<%@ include file="Navbar.jsp"%>
	<h1 style="padding-left: 10px;": 15px;">All Notes</h1>


	<div class="row d-flex justify-content-center p-4">
		<div class="col-10 ">
			<%
			try {
				Session hibernateSession = FactoryProvider.provider().openSession();
				Query query = hibernateSession.createQuery("from NotesTaker");
				List<NotesTaker> list = query.list();
				for (NotesTaker note : list) {
			%>
			<div class="card" style="width: 100%; margin-top: 15px; padding: 9px;">
				<img src=assets/notepad.png class="card-img-top" alt="img_err" style="width: 50px;">
				<div class="card-body">
					<h5 class="card-title"><%=note.getTitle()%></h5>
					<p class="card-text"><%=note.getContent()%></p>
					<div>
					<a href="Update_Note.jsp?note_id=<%=note.getId() %>" class="btn btn-primary">Update</a>
					<a href="Delete_Note?note_id=<%=note.getId()%>" class="btn btn-danger">Delete</a>
					</div>
				</div>
			</div>
			<%
			}
			hibernateSession.close();
			} catch (Exception e) {
			out.println("<p style='color:red;'>Error fetching notes: " + e + "</p>");
			}
			%>
		</div>
	</div>

</body>
</html>