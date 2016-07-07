<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>REGISTRAR DEPOSITO</h1>
	<p style="color:red;">${error}</p>
	<p style="color:blue;">${mensaje}</p>
	<form method="post" action="procDeposito.htm">
		<p>Cuenta: <input type="text" name="cuenta"/></p>
		<p>Importe: <input type="text" name="importe"/></p>
		<p><input type="submit" value="Procesar" /></p>
	</form>
	
</body>
</html>