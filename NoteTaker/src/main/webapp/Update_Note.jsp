<%@page import="com.entities.NotesTaker"%>
<%@page import="com.Factory.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="All_links.jsp"%>
<title>Update Note: NotesTaker</title>
</head>
<body>

	<%@ include file="Navbar.jsp"%>
	<h1 style="padding: 6px">Update Page</h1>
	<div class="container py-4">

		<%
		int id = Integer.parseInt(request.getParameter("note_id"));

		Session hibernateSession = FactoryProvider.provider().openSession();
		NotesTaker note = hibernateSession.get(NotesTaker.class, id);
		%>


		<form action="Update_Note" method="post">
			<input type="hidden" name="id" value=<%=note.getId()%>>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Title
					address</label> <input type="text" class="form-control"
					id="exampleInputEmail1" required="required"
					aria-describedby="emailHelp" name="title"
					value=<%=note.getTitle()%>>
			</div>
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea" name="content" style="height: 250px"
					required="required"><%=note.getContent()%></textarea>
				<label for="floatingTextarea">Add Note</label>
			</div>

			<button type="submit" class="btn btn-primary mt-3">Update</button>
		</form>
	</div>
</body>
</html>