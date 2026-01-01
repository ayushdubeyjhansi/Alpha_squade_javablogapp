<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Web Blog Login</title></head>
<body>
    <div style="width: 300px; margin: 100px auto; text-align: center; font-family: sans-serif;">
        <h2>Blog Web Access</h2>
        <h4 style="color:red">${error}</h4>

        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required style="padding: 5px;"><br><br>
            <input type="password" name="password" placeholder="Password" required style="padding: 5px;"><br><br>
            <button type="submit" style="padding: 5px 15px;">Login</button>
        </form>
    </div>
</body>
</html>