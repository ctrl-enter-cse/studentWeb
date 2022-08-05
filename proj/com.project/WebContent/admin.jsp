<%@page import="com.helper.DBhandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="style.css">
	</head>
	<body >
		<form action="out">
			<input type="submit" value="LOGOUT">
		</form>
		<%
			if(session.getAttribute("user")==null){
				response.sendRedirect("login.jsp");
			}
		%>
		
		      <div class="container">
          <div class="row mt-5">
            <!-- 1st column -->
              <div class="col-md-4">
              <a href="#">
                <div class="card" data-toggle="modal" data-target="#categoryModal">
                    <div class="card-body text-center">
                      <img src="img/category.png" class="img-fluid" style="max-width: 150px">
                      <h1>Add Category</h1>
                    </div>            
                </div>
                </a>
              </div>
            <!-- 2nd column -->
              <div class="col-md-4">
              <a href="#">
                <div class="card" data-toggle="modal" data-target="#productModal">
                    <div class="card-body text-center">
                      <img src="img/product.png" class="img-fluid" style="max-width: 150px">
                      <h1>Add Product</h1>
                    </div>            
                </div>
                </a>
              </div>
            <!-- 3rd column -->
              <div class="col-md-4">
              <a href="#">
                <div class="card" data-toggle="modal" data-target="#detailsModal">
                    <div class="card-body text-center">
                      <img src="img/details.png" class="img-fluid" style="max-width: 150px">
                      <h1>View Details</h1>
                    </div>            
                </div>
                </a>
              </div>
          </div>
      </div>

      <!-- Add category modal starts-->

      <!-- Modal -->
      <div class="modal fade" id="categoryModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add Category</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
				<form action="cat" method="post">
					  <div class="form-group">
					    <label>Category Name</label>
					    <input type="text" class="form-control" name="cat_name">
					  </div>
					  
					  <div class="form-group">
					    <label>Category Description</label>
					    <textarea class="form-control" name="cat_desc" rows="3"></textarea>
					  </div>
					  <input type="submit" class="btn btn-success" value="ADD CATEGORY">
				</form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>

      <!-- Add category modal ends-->

       <!-- Add product modal starts-->

      <!-- Modal -->
      <div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">Add Product</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              		<form action="pro" method="post" enctype="multipart/form-data">
              			<div class="form-group">
						    <label>Product Name</label>
						    <input type="text" class="form-control" name="prod_name">
						 </div>
						 <div class="form-group">
						    <label>Product Price</label>
						    <input type="text" class="form-control" name="prod_price">
						 </div>
					  
					  <div class="form-group">
					    <label>Product Description</label>
					    <textarea class="form-control" name="prod_desc" rows="3"></textarea>
					  </div>
					  <div class="form-group">
					    <label for="exampleFormControlFile1">Upload product image</label>
					    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="p_img">
					  </div>
					  <input type="submit" class="btn btn-success" value="ADD PRODUCT">
					</form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>

      <!-- Add product modal ends-->

       <!-- view details modal starts-->

      <!-- Modal -->
      <div class="modal fade" id="detailsModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLongTitle">View Details</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <h1>Number of users: <% out.print(DBhandler.getUserCount()); %></h1>
              
              <h1>Number of categories: <% out.print(DBhandler.getCategoryCount()); %></h1>
              
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>

      <!-- view details modal ends-->
		
		    

		<!--  scripts -->
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	</body>
</html>