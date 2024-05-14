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
@WebServlet("/add")
public class Adduserservlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		int age= Integer.parseInt( req.getParameter("age"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		
		 User ob=new User();
		   
		   ob.setName(name);
		   ob.setEmail(email);
		   ob.setMobile(mobile);
		   ob.setPassword(password);
		   ob.setAge(age);
		   
		   UserDao obj=new UserDao();
		   obj.Adduser(ob);
		   
	   HttpSession session=req.getSession();
      session.setAttribute("sucess", "Added User Sucessful");
	  resp.sendRedirect("home.jsp");
			
	}

}
