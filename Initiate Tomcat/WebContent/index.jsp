<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SBI</title>
</head>
<body>
<% out.print("welcome to SBI login"); %>

<div style="width: 50%; height: 30%;">

<form action="CrossSiteScripting" method="get">
User Name: <input type="text" name="user">
Password: <input type="text" name="passwd">
<input type="submit" value="Login">
</form>
</div>
</body>
</html>