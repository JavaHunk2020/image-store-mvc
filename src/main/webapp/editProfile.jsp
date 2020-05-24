<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title>Edit Profile</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <header style="height: 30px;background-color: #03a9f4;">
 </header>
   <div class="container">
      <br/>
     <img src="images/register.png" style="height: 150px;"  class="img-thumbnail">
   <img src="images/sleeping.png" style="height: 150px;" class="img-thumbnail">
    <img src="images/student.png" style="height: 150px;" class="img-thumbnail">
      <hr/>
      <span style="font-size: 18px;color: blue;font-weight: bold;">Edit Profile Page</span>
      <hr/>
      <div style="width: 50%">
      <form action="updateProfile">
       <input type="hidden"  name="aid"  value="${profileDTO.aid}">
      <label>Username</label>
      <input type="text" name="username"  class="form-control"   value="${profileDTO.username}">
         
        <label>Name</label>
      <input type="text" name="name"  class="form-control" value="${profileDTO.name}">
      
      <label>Email</label>
      <input type="email" name="email"  class="form-control"  value="${profileDTO.email}">
      <label>Gender</label>
      <select  name="gender"  class="form-control" style="width: 50%;">
         <option  ${profileDTO.gender=='Male' ? 'selected' :''}>Male</option>
         <option  ${profileDTO.gender=='Female' ? 'selected' :''}>Female</option>
      </select>
        <label>Image</label>
      <input type="text" name="image"  class="form-control" value="${profileDTO.image}">
        <img src="${profileDTO.image}" style="height: 100px;"  class="img-thumbnail">
            <br/>
      <br/>
      <button type="submit" class="btn btn-primary">Update</button>
       <a href="login.jsp">
      <button type="button" class="btn btn-danger">Login</button>
      </a>
      </form>
      </div>
   </div>
</body>
</html>