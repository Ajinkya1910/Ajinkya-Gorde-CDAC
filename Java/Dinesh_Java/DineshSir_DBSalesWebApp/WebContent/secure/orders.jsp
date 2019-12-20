<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="m" uri="https://sales.met.web"%> 

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="login" class="com.met.model.LoginBean" scope="session"></jsp:useBean>    
<jsp:useBean id="orderBean" class="com.met.model.OrderBean">
	<jsp:setProperty name="orderBean" property="*"></jsp:setProperty>
</jsp:useBean>    
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome ${login.userName}</h1>
	
	<form>
		<input type="hidden" value="${login.userName}" name="userName"/>
		<table>
			<tr>
				<td>Pno: </td>
				<td>
					<select name="pno">
						<m:getProducts>
							<option>${product.pid }</option>
						</m:getProducts>
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantity: </td>
				<td> <input type="text" name="quantity" /> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Place Order" name="order">
				</td>
			</tr>
		</table>
	</form>
	
	
	<c:if test="${param.order == 'Place Order'}">
		<p><b>Order Number: </b></p> ${orderBean.newOrderNo }
	</c:if>
	
	<a href="../logout">logout</a>
	
</body>
</html>


