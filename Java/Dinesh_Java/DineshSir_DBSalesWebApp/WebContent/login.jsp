<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Login Screen</h1>	
	<br/>
	<br/>
    <div align="center">
		<form action="login" method="post">
			Username: <input type="text" name="userName" value="${cookie.userName.value }"/>
			<br/>Password: <input type="password" name="password" />
			<br/><input type="submit" value="Login" name="login">
		</form>
	</div>

</body>
</html>