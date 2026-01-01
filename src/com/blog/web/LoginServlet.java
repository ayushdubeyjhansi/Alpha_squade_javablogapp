package com.blog.web;

import com.blog.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Uses your existing logic classes
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private IDataService dataService;

    @Override
    public void init() {
        dataService = new DatabaseService(); // Connects to same DB as Swing
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uName = request.getParameter("username");
        String pass = request.getParameter("password");

        if (dataService.authenticateUser(uName, pass)) {
            // Success: Create com.blog.web.com.blog.model.User object and save to Session
            User user = uName.equalsIgnoreCase("admin") ? new AdminUser(uName) : new RegularUser(uName);
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect("feed");
        } else {
            // Fail: Send back to login page
            request.setAttribute("error", "Invalid Credentials");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}