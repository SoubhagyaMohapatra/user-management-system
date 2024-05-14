<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delate</title>
<%@ include file="component/bootstrapCss.jsp" %>
 
   
</head>
<body>
<%   User use= (User)session.getAttribute("userObj");
      if(use==null){
      response.sendRedirect("login.jsp");
     }else{%>	
    <%@ include file="component/homeNavbar.jsp" %>
       <%} %>



  <% String Strid=request.getParameter("id");
         int id=Integer.parseInt(Strid);
         UserDao dao=new UserDao();
         User user=dao.fetchbyuserbyId(id);
          %>
   

    <div class="delete-form" style="align-items: center" >
        <h2><center>Are you sure ?</center></h2>
       <center> 
                     <form action="delate" method="post">
                     <input type="submit" class="btn btn-success text-decoration-none" value="Yes">
                     <input type="hidden" name="id" value="<%=user.getId()%>"> 
                     </form> <a href="home.jsp" class="btn btn-danger text-decoration-none">NO</a>
                    
                     
		             
       </center>
    </div>










</body>
</html>