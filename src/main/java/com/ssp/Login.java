package com.ssp;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")

public class Login extends HttpServlet {
	
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String eml=req.getParameter("Email");
		String np=req.getParameter("newpass");
		HttpSession session=req.getSession();
		session.setAttribute("eml", "patil@gmail.com");
		session.setAttribute("np","gpp");
		resp.sendRedirect("Hostel");
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "root");
			
            PreparedStatement p = c.prepareStatement("Select * from register where eml=? AND np=?");
            
            p.setString(1, eml);
            
            p.setString(2, np);
            
            ResultSet r=p.executeQuery();
      
		
	System.out.println("App is running"+r);
            c.close();

        } catch (Exception  e) {
           
            e.printStackTrace();
        }
	
}
}
