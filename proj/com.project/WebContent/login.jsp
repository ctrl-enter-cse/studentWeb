<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login Page</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	</head>
	<body>
	<!-- 
		<form action="in" method="post">
			<label>USER : </label><input type="text" name="uname">
			<label>PASS : </label><input type="text" name="pass">
			<br>
			<input type="submit" value="LOGIN">
		</form>
		
		<br>
		
		
		<a href="register.jsp">Register here</a>	
	-->
			
		<%@include file="msg.jsp" %>
		
		  <form class="px-4 py-3" action="in" method="post">
			    <div class="form-group">
			      <label>User name</label>
			      <input type="text" class="form-control" placeholder="Enter username" name="uname">
			    </div>
			    <div class="form-group">
			      <label for="exampleDropdownFormPassword1">Password</label>
			      <input type="password" class="form-control" placeholder="Enter Password" name="pass">
			    </div>
			   
			    <button type="submit" class="btn btn-primary">Sign in</button>
		  </form>
		  <div class="dropdown-divider"></div>
		  <a class="dropdown-item" href="register.jsp">New around here? Sign up</a>
	
	
		
		<!--  scripts -->
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	</body>
</html>