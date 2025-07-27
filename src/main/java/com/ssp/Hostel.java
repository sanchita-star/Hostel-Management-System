package com.ssp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/HostelServlet")
public class Hostel extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Assume user data comes from LoginServlet via session
        HttpSession session = request.getSession();
        String eml = (String) session.getAttribute("Email");
        String np = (String) session.getAttribute("newpass");

        // Set attributes to display on homepage
        request.setAttribute("Email", eml);
        request.setAttribute("newpass", np);

        // Forward to hostel.html (converted to JSP so it can show values)
        RequestDispatcher dispatcher = request.getRequestDispatcher("hostel.jsp");
        dispatcher.forward(request, response);
        
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