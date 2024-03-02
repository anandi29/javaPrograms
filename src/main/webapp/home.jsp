<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <%= session.getAttribute("useremail") %></h1>
<a href="display.jsp">Display Details</a>
<a href="update.jsp">Update</a>
<a href="delete">Delete</a>
<a href="logout">logout</a>
</body>
</html>