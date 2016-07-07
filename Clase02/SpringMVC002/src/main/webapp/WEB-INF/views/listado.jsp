<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>CATALOGO</h1>
	<table border="1">
	
		<tr>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>STOCK</th>
		</tr>
	
		<c:if test="${sessionScope.lista != null}">
			<c:forEach items="${sessionScope.lista}" var="r">
			<tr>
				<td>${r.nombre}</td>
				<td>${r.precio}</td>
				<td>${r.stock}</td>
			</tr>
			</c:forEach>
		</c:if>
	
	</table>
</body>
</html>