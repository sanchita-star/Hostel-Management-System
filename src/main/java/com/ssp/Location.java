//i have used concept of Sendredirect() sevlet in this location.

package com.ssp;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LocationRedirectServlet")
public class Location extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect to your hostel location on Google Maps
        response.sendRedirect("https://maps.app.goo.gl/pGqSyWBEStH7Q1py8?g_st=aw");
    }
}