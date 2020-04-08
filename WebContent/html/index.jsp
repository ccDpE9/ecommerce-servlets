<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="java.util.ArrayList" 
    import="com.ccDpE9.ecommerce_servlet.beans.Product"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> products = (ArrayList)request.getAttribute("products");
for (Product product: products) {
%>
<div>
<p><%=product.getName() %>
<button>Add to cart</button>
</div>
<% } %>
</body>
</html>