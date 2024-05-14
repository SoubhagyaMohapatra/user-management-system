<%@page import="com.org.dao.UserDao"%>
<%@  page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update user</title>
<%@ include file="component/bootstrapCss.jsp" %>
</head>
<body>
<%   User use= (User)session.getAttribute("userObj");
      if(use==null){
      response.sendRedirect("login.jsp");
     }else{
     %>	
    <%@ include file="component/homeNavbar.jsp" %>
       <%} %>
       
       
     <%
         String Strid=request.getParameter("id");
         int id=Integer.parseInt(Strid);
         UserDao dao=new UserDao();
         User user=dao.fetchbyuserbyId(id);
          %>
          
          
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Update User</p>

                   <form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control"  value="<%= user.getName() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel"  class="form-control"  value="<%= user.getAge() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control"   value="<%= user.getMobile() %>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email"   class="form-control"   value="<%= user.getEmail() %>"required>
							</div>
							<input type="hidden" name="id" value="<%=user.getId()%>"> 
							<button type="submit" class="btn bg-primary text-white col-md-12">Update User</button>
							
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>