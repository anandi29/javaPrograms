<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="update" method="post">
<p>select field name to change</p>

<input name="field" type="radio" value="name"/>name<br/>

<input type="radio" name="field" value="phonenumber"/>phone number<br/>
<input type="text" name="fieldValue" placeholder="enter field value">
<input type="submit">
</form>
</body>
</html>