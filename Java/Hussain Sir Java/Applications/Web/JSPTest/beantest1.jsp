<jsp:useBean id="ctr" class="basic.web.app.CounterBean" scope="application"/>
<jsp:setProperty name="ctr" property="step" value="2"/>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Visitor</h1>
		<b>Number of greetings: </b>${ctr.nextCount}
	</body>
</html>

