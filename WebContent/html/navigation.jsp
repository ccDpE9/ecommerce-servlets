<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav>
	<ul>
		<li>Cart</li>
		<%
			if (session.getAttribute("email") != null) {
				%>
				<li><a href="/ecommerce-servlets/logout">Log out</a>
				<%
			} else {
				%>
				<li><a href="/ecommerce-servlets/login">Login</a>
				<li><a href="/ecommerce-servlets/register">Register</a>
				<%
			}
		%>
	</ul>
</nav>
</body>
</html>