<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<%@ include file="component/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
body {
	           
 background-image: url("https://img.freepik.com/free-vector/realistic-galaxy-background_23-2148991322.jpg?t=st=1714413160~exp=1714413760~hmac=801d75cc48182659daf2af8bc31f014342b0a668dde54b9d43e5803479a4301a");
 background-size: cover;
            }
            
	
}
</style>

</head>
<body>
<%@ include file="component/navbar.jsp" %>
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Login</p>
						
						<%  String Msg=(String)session.getAttribute("wrong");
						
						
						if(Msg!=null){
							%>
							<p class ="text-center text-danger fs-4"> <%=Msg %></p>
						<%
						session.removeAttribute("wrong");
						}
						%>
						
						
						
						
						
						
						<form action="login" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
				 <h5 style="color: white">If don't have any Account <a href="register.jsp">Register</a></h5>
			</div>
		</div>
	</div>


</body>
</html>
    
