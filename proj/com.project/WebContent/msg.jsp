<%
	String msg=(String)session.getAttribute("message");
	if(msg!=null){
		//out.print(msg);
%>		
		
		
		
		
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <strong><%= msg %></strong> Please SIGN IN to continue.
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
<%	
		session.removeAttribute("message");
	}
%>