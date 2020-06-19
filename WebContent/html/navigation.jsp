<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<nav>
	<ul>
		<li>Cart</li>
		<c:if test="${session.getAttribute("email") != null}">
			<li>Logout</li>
		</c:if>
		<c:if test="${session.getAttribute("email") == null}">
			<li>Login</li>
			<li>Register</li>
		</c:if>
	</ul>
</nav>
</body>
</html>