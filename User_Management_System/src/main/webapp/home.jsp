<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="component/bootstrapCss.jsp" %>
</head>
<body>
<%

User user= (User)session.getAttribute("userObj");
if(user==null){
	response.sendRedirect("login.jsp");
}else{
%>

<%@ include file="component/homeNavbar.jsp" %>
  <h1 class="text-center">

<p class ="text-center text-success fs-4">  Hey  <%= user .getName() %>
  Welcome to home page</p>
 
  </h1>  
 <%} %>
 
 
 
 <div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
					
						<p class="fs-3 text-center">User Details</p>
						
						
						<%  String Msg=(String)session.getAttribute("update");
						
						
						if(Msg!=null){
							%>
							<p class ="text-center text-success fs-4"> <%=Msg %></p>
						<%
						session.removeAttribute("update");
						}
						%>
					
					<%//----------------------------------------------------------------- %>	
						
						
							<%  String Ms=(String)session.getAttribute("sucess");
						
						
						if(Ms!=null){
							%>
							<p class ="text-center text-success fs-4"> <%=Ms %></p>
						<%
						session.removeAttribute("sucess");
						}
						%>
						
						<%//----------------------------------------------------------------- %>	
						
						<%  String Msg1=(String)session.getAttribute("delate");
						
						
						if(Msg1!=null){
							%>
							<p class ="text-center text-danger fs-4"> <%=Msg1 %></p>
						<%
						session.removeAttribute("delate");
						}
						%>
						
						
						<a href="add.jsp" class="text-decoration-none btn btn-primary">Add
							User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>
								
                       <%
                     UserDao ob=new UserDao();
                      List<User> list=ob.fetchAllUser();
                      for(User u : list){
                    	  
                
                      if(user.getId()==u.getId()){
                    	  continue;
                      }%>
                      
                      <tr>
									<td><%= u.getName() %></td>
									<td><%= u.getAge() %></td>
									<td><%= u.getEmail() %></td>
									<td><%= u.getMobile()%></td>
		                            <td> <a href="update.jsp?id=<%=u.getId() %>" class="btn btn-success text-decoration-none">Update</a>
		                             <a href="delate.jsp?id=<%=u.getId() %>" class="btn btn-danger text-decoration-none">Delate</a></td>
								</tr>
								
                      
                      
                      
                     <% }
                                %>
							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
 
 
</body>
</html>