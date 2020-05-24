<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="height: 30px; background-color: #03a9f4;"> </header>
	<div class="container">
		<br /> <img src="${magic.image}" style="height: 150px;"
			class="img-thumbnail"> <img src="images/sleeping.png"
			style="height: 150px;" class="img-thumbnail"> <img
			src="images/student.png" style="height: 150px;" class="img-thumbnail">
			<a href="profiles">
			<img
			src="images/group.png" style="height: 150px;" class="img-thumbnail">
			</a>
		<hr />
		<h3>${msg}</h3>
		<h4>Hello ! We welcome you   ${magic.name}!!!!!!!!!!!!!!!!!!!!!!!</h4>
		<h4>Email : ${magic.email}</h4>
			<h4>Gender : ${magic.gender}</h4>
				<h4>Role : ${magic.role}</h4>
				<h4>Unique Id : ${magic.aid}
				<a href="editProfile?aid=${magic.aid}">
					<img src="images/edit.png" style="height: 24px;">
				</a>
				</h4>
				
		<img src="images/welcome.png" class="rounded-circle">
		<hr />
		<a href="login.jsp">
			<button type="button" class="btn btn-primary">Back</button>
		</a>
	</div>
</body>
</html>