package com.ssp;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Studentregi extends HttpServlet {

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stunme = request.getParameter("StudentName");
        String eml=request.getParameter("Email");
        String phno = request.getParameter("PhoneNumber");
        int mob = 0;
        try{
        	mob=Integer.parseInt(phno);
        }catch (NumberFormatException e) {
			mob=-1;
		}
        String Clgnme = request.getParameter("Collegename");
        String Cls = request.getParameter("ClassName");
        String Add = request.getParameter("Address");
        String np = request.getParameter("newpass");
        String cp = request.getParameter("confirmpass");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println(stunme);
		out.print(eml);
		out.println(mob);
		out.println(Clgnme);
		out.println(Cls);
		out.println(Add);
		out.println(np);
		out.println(cp);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "root");
			
            PreparedStatement p = c.prepareStatement("INSERT INTO register (studnme, eml, phoneno, clgnme, cl1, address, npass, cpass) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            p.setString(1, stunme);
            p.setString(2, eml);
            p.setInt(3, mob);
            p.setString(4, Clgnme);
            p.setString(5, Cls);
            p.setString(6, Add);
            p.setString(7, np);
            p.setString(8, cp);
            p.executeUpdate();

            out.println("Registration successful!");
            response.sendRedirect("login.html");
            c.close();

        } catch (Exception  e) {
            out.println("<h3>Error during registration: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
       
    }
}