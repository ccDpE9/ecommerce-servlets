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
<jsp:include page="/html/navigation.jsp"/>
<%
List<Product> products = (ArrayList)request.getAttribute("products");
for (Product product: products) {
%>
<div>
<p><%=product.getName() %></p>
<img src="<% out.print("image?path=" + product.getImg()); %>" height="200" width="200" />
<button>Add to cart</button>
</div>
<% } %>
</body>
</html>