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

@WebServlet("/password")
public class Change_passwordservlet extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		 User use= (User)session.getAttribute("userObj");
		 
		// int id=Integer.parseInt(req.getParameter("id"));
		 String currentpass= req.getParameter("old");
	     String new1= req.getParameter("new-1");
         String new2= req.getParameter("new-2");
		 
		 
         
         if( use.getPassword().equals(currentpass)) {
        	 
        	 if(new1.equals(new2)) {
        		 
        		 if(!currentpass.equals(new2)) {
        			 
        			 User ob=new User();
    				
        				ob.setPassword(new2);
        				ob.setId(use.getId());
//        				ob.setAge(use.getAge());
//        				ob.setMobile(use.getMobile());
//        				ob.setName(use.getName());
        				UserDao dao=new UserDao();
        				dao.ChangePasswordById(ob);
        				
        				session.setAttribute("changepa", "Password Updated Sucessfully");
        				resp.sendRedirect("change_password.jsp");
        			 
        		 }else {
        			 
        			 session.setAttribute("changep","Previous password and Current password must be different");
           			resp.sendRedirect("change_password.jsp");
        		 }
        		 
        	 }
        	 else {
        		 session.setAttribute("changep","Password Not Matched");
      			resp.sendRedirect("change_password.jsp");
        	 }
        	 
        	 
         }
         else {
        	 
        	 session.setAttribute("changep","Previous Password Not correct");
 			resp.sendRedirect("change_password.jsp");
         }
         
         
         
         
         
//		if ( use.getPassword().equals( currentpass) && new1.equals(new2) && !currentpass.equals(new1) ) {
//			//&& !currentpass.equals(new1)
//			User ob=new User();
//			
//			ob.setPassword(new2);
//			ob.setId(use.getId());
//			ob.setAge(use.getAge());
//			ob.setMobile(use.getMobile());
//			ob.setName(use.getName());
//			UserDao dao=new UserDao();
//			dao.ChangePasswordById(ob);
//			
//			session.setAttribute("changepa", "Password Updated Sucessfully");
//			resp.sendRedirect("change_password.jsp");
//		}
//		else {
//			
//			session.setAttribute("changepa","Invalid Craiteria");
//			resp.sendRedirect("change_password.jsp");
		} 
	}

