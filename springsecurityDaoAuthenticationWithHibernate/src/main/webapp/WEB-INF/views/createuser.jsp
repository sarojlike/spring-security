<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to create user</h1>

<form:form action="${pageContext.request.contextPath}/createUser" method="post" modelAttribute="user">

	Enter Name : <form:input path="name" /><br>
	Enter Login-Name : <form:input path="loginName" /><br>
	Enter password : <form:password path="password" /><br>
	<input type="submit" name="submit"><br>

</form:form>
<br>

<a href="${pageContext.request.contextPath}/login">Login</a>

</body>
</html>