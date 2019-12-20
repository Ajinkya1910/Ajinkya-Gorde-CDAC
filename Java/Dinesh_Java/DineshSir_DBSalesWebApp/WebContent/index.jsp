<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="m" uri="https://sales.met.web"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Available Products</h1>
	<%-- <m:getProducts>
		
	</m:getProducts> --%>
	
	<table align="center" border="1">
		<tr>
			<th>PNO</th>
			<th>PRICE</th>
			<th>STOCK</th>
		</tr>
		
		<m:getProducts>
			<tr>
				<td>${product.pid }</td>
				<td>${product.price }</td>
				<td>${product.stock }</td>
			</tr>
		</m:getProducts>
		
	</table>
	
	<br/>
	<br/>
	
	
	<a href="login.jsp">Login</a>
	
	
</body>
</html>