<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
<%@ include file="component/bootstrapCss.jsp" %>
</head>
<body>
<%   User use= (User)session.getAttribute("userObj");
      if(use==null){
      response.sendRedirect("login.jsp");
     }else{%>	
    <%@ include file="component/homeNavbar.jsp" %>
       <%} %>


    <center>  <h2 style="color: red"> Are You Sure Darling !!!!!</h2></center>
<center>
 <a href="logout" class="btn btn-danger text-decoration-none">Yes</a>
 <a href="home.jsp" class="btn btn-success text-decoration-none">No</a>
</center>
</body>
</html>