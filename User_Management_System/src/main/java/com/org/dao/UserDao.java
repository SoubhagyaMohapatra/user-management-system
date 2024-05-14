package com.org.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;
public class UserDao {

	
	public void saveUser(User user) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			
			PreparedStatement pstd=con.prepareStatement("insert into user_mgm(name,age,email,password,mobile) values(?,?,?,?,?)");
			pstd.setString(1, user.getName());
			pstd.setInt(2, user.getAge());
			pstd.setString(3,user.getEmail());
			pstd.setString(4,user.getPassword());
			pstd.setLong(5,user.getMobile() );
			
			pstd.executeUpdate();
			
			con.close();
			
			//System.out.println("register sucess");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public User fetchUserByEmailAndPassword(String email, String password) {
		
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		PreparedStatement pstd=con.prepareStatement("select * from user_mgm where email=? and password=?");
		pstd.setString(1,email);
		pstd.setString(2,password);
		ResultSet rst=pstd.executeQuery();
		
		if (rst.next()) {
			
			User user=new User();
		    String name=rst.getString("name");
			int age=rst.getInt("age");
			String email1=rst.getString("email");
			String password1=rst.getString("password");
			long mobile=rst.getLong("mobile");
			int id=rst.getInt("id");
			
			
			
			user.setId(id);
			user.setAge(age);
			user.setEmail(email1);
			user.setMobile(mobile);
			user.setName(name);
			user.setPassword(password1);
			return user;
			
		}
		con.close();
	} 
	
	
	
	catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return null;
	
}
	
	
	public User fetchbyuserbyId(int id) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pstd=con.prepareStatement("select * from user_mgm where id=?");
			pstd.setInt(1,id);
			
			ResultSet rst=pstd.executeQuery();
			
			if (rst.next()) {
				
				User user=new User();
			    String name=rst.getString("name");
				int age=rst.getInt("age");
				String email1=rst.getString("email");
				String password1=rst.getString("password");
				long mobile=rst.getLong("mobile");
				int id1=rst.getInt("id");
				
				
				
				user.setId(id1);
				user.setAge(age);
				user.setEmail(email1);
				user.setMobile(mobile);
				user.setName(name);
				user.setPassword(password1);
				return user;
				
			}
			con.close();
		} 
		
		
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return null;
		
		//return User;
		//return user;
	}
	
	
	
	public List<User>fetchAllUser(){
		List<User> ob=new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pstd=con.prepareStatement("select * from user_mgm");
			
			
			ResultSet rst=pstd.executeQuery();
			
			while (rst.next()) {
				
				User user=new User();
			    String name=rst.getString("name");
				int age=rst.getInt("age");
				String email1=rst.getString("email");
				//String password1=rst.getString("password");
				long mobile=rst.getLong("mobile");
				int id1=rst.getInt("id");
				
				
				
				user.setId(id1);
				user.setAge(age);
				user.setEmail(email1);
				user.setMobile(mobile);
				user.setName(name);
				//user.setPassword(password1);
				//return user;
				ob.add(user);
			}
			
			
			con.close();
			return ob  ;
		} 
		
		
		
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			return null;
		
	}
// Add User--------	
	public void Adduser(User user) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			
			PreparedStatement pstd=con.prepareStatement("insert into user_mgm(name,age,email,password,mobile) values(?,?,?,?,?)");
			pstd.setString(1, user.getName());
			pstd.setInt(2, user.getAge());
			pstd.setString(3,user.getEmail());
			pstd.setString(4,user.getPassword());
			pstd.setLong(5,user.getMobile());
			
			pstd.executeUpdate();
			
			con.close();
		
} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
		
		//update user----------
	
		public void UpdateUser(User user) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
				PreparedStatement pstd=con.prepareStatement("update user_mgm set name=?,age=?,email=?,mobile=? where id=?");
				
				pstd.setString(1, user.getName());
				pstd.setInt(2, user.getAge());
				pstd.setString(3,user.getEmail());
				pstd.setLong(4,user.getMobile());
				pstd.setInt(5,user.getId());
				
				pstd.executeUpdate();
				
				con.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		// Delate User ------------------------------------
		 public void DelateById(User user) {
			 
			 
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
				PreparedStatement pstd=con.prepareStatement("delete from user_mgm where id=?");
				
                pstd.setInt(1,user.getId());
				pstd.executeUpdate();
				con.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		 }
		public void  ChangePasswordById(User user){
			 
			try {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
	            PreparedStatement pstd=con.prepareStatement("update user_mgm set password=? where id=?");
	            pstd.setString(1,user.getPassword());
                pstd.setInt(2,user.getId());
				pstd.executeUpdate();
				con.close();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
				
				
			
			
			
		 }
	
	
}
