package com.blog.web;
import com.blog.model.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/feed")
public class FeedServlet extends HttpServlet {

    private IDataService dataService;

    @Override
    public void init() {
        dataService = new DatabaseService();
    }

    // SHOW POSTS (GET Request)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Security Check
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get Data shared with Swing App
        List<BlogPost> posts = dataService.getAllPosts();
        request.setAttribute("allPosts", posts);

        // Send to JSP
        request.getRequestDispatcher("feed.jsp").forward(request, response);
    }

    // ADD POST (POST Request)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("currentUser") != null) {

            String title = request.getParameter("title");
            String content = request.getParameter("content");
            User user = (User) session.getAttribute("currentUser");

            // Reuse your existing com.blog.web.com.blog.model.BlogPost logic
            if (title != null && !title.isEmpty()) {
                BlogPost newPost = new BlogPost(title, content, user);
                dataService.addPost(newPost); // Saves to MySQL
            }
        }
        response.sendRedirect("feed"); // Refresh page
    }
}