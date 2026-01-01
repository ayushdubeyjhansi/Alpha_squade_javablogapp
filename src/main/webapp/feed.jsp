<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.blog.model.User" %>
<%@ page import="com.blog.model.BlogPost" %>

<!DOCTYPE html>
<html>
<head>
    <title>Blog Feed</title>
    <style>
        /* Your CSS here */
        body { font-family: sans-serif; max-width: 800px; margin: 0 auto; padding: 20px; }
        .card { border: 1px solid #ddd; padding: 15px; margin-bottom: 15px; border-radius: 8px; box-shadow: 2px 2px 5px #eee; }
        .header { background: #4682B4; color: white; padding: 15px; border-radius: 8px; margin-bottom: 20px; }
        a { color: white; text-decoration: underline; }
    </style>
</head>
<body>
    <% User user = (User) session.getAttribute("currentUser"); %>

    <div class="header">
        <h1>Welcome, <%= user.getUsername() %></h1>
        <p>This feed is synced with your Desktop App.</p>
        <a href="logout">Logout</a>
    </div>

    <div class="card" style="background: #f9f9f9;">
        <h3>Write New Post</h3>
        <form action="feed" method="post">
            <input type="text" name="title" placeholder="Title..." style="width:100%; margin-bottom:10px;" required>
            <textarea name="content" placeholder="Content..." style="width:100%; height:80px;" required></textarea>
            <br>
            <button type="submit">Publish</button>
        </form>
    </div>

    <h3>Recent Posts</h3>
    <%
        List<BlogPost> list = (List<BlogPost>) request.getAttribute("allPosts");
        if(list != null) {
            for(BlogPost p : list) {
    %>
        <div class="card">
            <h3 style="margin-top:0;"><%= p.title %></h3>
            <small style="color:gray">By <%= p.author.getUsername() %></small>
            <p><%= p.content %></p>
            <small>Likes: <%= p.likes %></small>
        </div>
    <%
            }
        }
    %>
</body>
</html>