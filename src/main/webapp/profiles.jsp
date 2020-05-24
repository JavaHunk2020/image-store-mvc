<%@page import="java.util.List"%>
<%@page import="com.rab3.dto.ProfileDTO"%>
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
		<h4>Profiles Data</h4>
		<hr />
		 <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Photo</th>
        <th>Created Date</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
    
    <%
    List<ProfileDTO> profileDTOs=(List<ProfileDTO>)request.getAttribute("profileDTOs");
    for(ProfileDTO dto:profileDTOs) {
    %>
      <tr>
        <td><%=dto.getUsername() %></td>
          <td><%=dto.getName() %></td>
            <td><%=dto.getEmail() %></td>
              <td><%=dto.getGender() %></td>
        <td><img src="<%=dto.getImage()%>"  style="height: 80px;"></td>
          <td><%=dto.getDoe() %></td>
         <td>
          <a href="deleteProfile?uname=<%=dto.getUsername() %>">
         <img src="images/icons8-delete-100.png"  style="height: 80px;">
         </a>
         &nbsp;  &nbsp;  &nbsp;
         <a href="editProfile?aid=<%=dto.getAid() %>">
					<img src="images/edit.png" style="height: 24px;">
				</a>
         </td>
      </tr>
   <%} %>
    </tbody>
  </table>
		
		<a href="login.jsp">
			<button type="button" class="btn btn-primary">Back</button>
		</a>
	</div>
</body>
</html>