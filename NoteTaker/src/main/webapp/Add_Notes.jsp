<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="All_links.jsp"%>
<title>Add Form: NoteTaker</title>
</head>
<body>

	<%@ include file="Navbar.jsp"%>
	<div class="container py-4">
		<form action="Add_Form" method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Title
					address</label> <input type="text" class="form-control"
					id="exampleInputEmail1" required="required" aria-describedby="emailHelp" name="title">
			</div>
			<div class="form-floating">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea" name="content" style="height: 250px" required="required"></textarea>
				<label for="floatingTextarea">Add Note</label>
			</div>

			<button type="submit" class="btn btn-primary mt-3">Submit</button>
		</form>
	</div>


</body>
</html>