package com.org.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/update")
public class Updateservlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String name=req.getParameter("name");
	String age1=req.getParameter("age");
	String email=req.getParameter("email");
	String mobile1=req.getParameter("mobile");
	String id1=req.getParameter("id");
	
	int age=Integer.parseInt(age1);
	long mobile=Long.parseLong(mobile1);
	int id= Integer.parseInt(id1);
	
	  User ob=new User();
	   
	   ob.setName(name);
	   ob.setAge(age);
	   ob.setEmail(email);
	   ob.setMobile(mobile);
	   ob.setId(id);
	   
	   UserDao dao=new UserDao();
	   dao.UpdateUser(ob);
	   
	   HttpSession session=req.getSession();
	   session.setAttribute("update", "updated Sucessfuly");
		
	   resp.sendRedirect("home.jsp");
		
}
}
