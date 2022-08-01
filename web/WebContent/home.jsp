<%-- <% --%>
// if(session.getAttribute("name")==null||session.getAttribute("name")==""){
// 	response.sendRedirect("login.jsp");		
// }
<%-- %> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome 
<nav class="navbar navbar-expand-lg navbar-dark bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top"><%= session.getAttribute("name") %></a>
<!-- 			<button -->
<!-- 				class="navbar-toggler text-uppercase font-weight-bold navbar-light bg-light text-rounded" -->
<!-- 				type="button" data-bs-toggle="collapse" -->
<!-- 				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" -->
<!-- 				aria-expanded="false" aria-label="Toggle navigation"> -->
<!-- 				Menu <i class="fas fa-bars"></i> -->
<!-- 			</button> -->
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="portfolio.jsp" method="doGet">Portfolio</a></li>				
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
<!-- 					<li class="nav-item mx-0 mx-lg-1"  ><a -->
<!-- 						class="nav-link py-3 px-0 px-lg-3 rounded" href="edits.jsp">edits</a></li> -->
				</ul>
			</div>
		</div>
	</nav>
	<br><br><br>
<marquee  style="animation:slide-left 2000" scrollamount=20> <h1 >welcome to page</h1> </marquee>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>