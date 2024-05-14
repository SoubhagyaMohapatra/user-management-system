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
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%   User use= (User)session.getAttribute("userObj");
      if(use==null){
      response.sendRedirect("login.jsp");
     }else{
     %>	
    <%@ include file="component/homeNavbar.jsp" %>
       <%} %>
       
       
    
         
       
          
          
          <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Change Password</p>
	
	                <%  String Msg=(String)session.getAttribute("changepa");
						
						
						if(Msg!=null){
							%>
							<p class ="text-center text-success fs-4"> <%=Msg %></p>
						<%
						session.removeAttribute("changepa");
						}
						%>
			<%//------------------------------------------------------------------- --%>			
						<%  String Msg1=(String)session.getAttribute("changep");
						
						
						if(Msg1!=null){
							%>
							<p class ="text-center text-danger fs-4"> <%=Msg1 %></p>
						<%
						session.removeAttribute("changep");
						}
						%>
						
						
						
						
						
						
						
						<form action="password" method="post">
							<div class="mb-3">
								<label class="form-label">Enter Previous Password</label> <input
									name="old" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Enter New Password</label> <input
									name="new-1" type="password" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Re-Enter New Password</label> <input
									name="new-2" type="password" class="form-control" required>
							</div>
							<input type="hidden" name="id" value="<%=use.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Change Password</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>