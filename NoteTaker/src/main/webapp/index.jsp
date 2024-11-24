<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="All_links.jsp"%>
<title>Note Taker</title>
</head>
<body>
	<%@ include file="Navbar.jsp"%>
	<div class="container-fluid">
	
	<div class="card text-center" style="display:flex; justify-content: center; align-items: center; ">
		<img src=assets/notepad.png class="card-img-top" alt="img_err" style="width:400px">
		<div class="card-body " style="display:flex; flex-direction:column ; justify-content: center; align-items: center; ">
			<h5 class="card-title">Add Notes To Make It Memories!</h5>
			<a href="Add_Notes.jsp" class="btn btn-primary">Click Me</a>
		</div>
	</div>
	</div>
</body>
</html>