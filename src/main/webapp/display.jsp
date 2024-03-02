<%@page import="java.sql.ResultSet"%>
<%@page import="loginPackage.Database"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Database d=new Database();
 String useremail=(String)session.getAttribute("useremail");
ResultSet result=d.displayData(useremail);
while(result.next()){
	out.print(result.getString("name"));
	out.print(result.getString("email"));
	out.print(result.getLong("phone"));
}
%>

</body>
</html>