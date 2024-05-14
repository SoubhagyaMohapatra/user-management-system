<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<%@ include file="component/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
body {
	           
 background-image: url("https://img.freepik.com/free-vector/geometric-gradient-futuristic-background_23-2149116406.jpg?w=826&t=st=1714457049~exp=1714457649~hmac=f9995ac2ea16cbf2d54855f859ad3d738c35a00aec043dcd0d69a4806cb5b143");
 background-size: cover;
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
						<p class="fs-4 text-center">Registration Page</p>
						
						<%  String Msg=(String)session.getAttribute("sucess");
						
						
						if(Msg!=null){
							%>
							<p class ="text-center text-success fs-4"> <%=Msg %></p>
						<%
						session.removeAttribute("sucess");
						}
						%>
						
						
						<form action="register" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" class="form-control" required>
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Register</button>
						</form>
             
					</div>
					
				</div>
				 <h5 style="color: white"> If Already Registered Go To <a href="login.jsp">Login</a></h5>
            
			</div>
		</div>
	</div>


</body>
</html>