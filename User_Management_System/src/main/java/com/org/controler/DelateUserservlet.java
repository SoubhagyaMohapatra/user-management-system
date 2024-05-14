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

@WebServlet("/delate")
public class DelateUserservlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 =req.getParameter("id");
		
		int id=Integer.parseInt(id1);
		
		User ob=new User();
		ob.setId(id);
		
		UserDao dao=new UserDao();
		dao.DelateById(ob);
		
		
		HttpSession session=req.getSession();
		session.setAttribute("delate","Delete Sucessfully");
		resp.sendRedirect("home.jsp");
	}
	
	
}
