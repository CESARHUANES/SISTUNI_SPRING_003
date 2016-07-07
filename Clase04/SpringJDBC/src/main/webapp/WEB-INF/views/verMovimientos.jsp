<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CONSULTA DE MOVIMIENTOS</h1>
	<form method="post" action="verMovimientos.htm">
		<p>
			Cuenta: <input type="text" name="cuenta"/>
			<input type="submit" value="Consultar" />
		</p>
	</form>
	<c:if test="${error != null}">
		<p style="color: red;">${error}</p>
	</c:if>
	<c:if test="${ ! empty lista }">
		
		<table>
			<tr>
				<td>Cuenta:</td>
				<td>${lista[0].cuencodigo}</td>
				<td width="50"></td>
				<td>Estado:</td>
				<td>${lista[0].cuenestado}</td>
			</tr>
			<tr>
				<td>Moneda:</td>
				<td>${lista[0].monenombre}</td>
				<td></td>
				<td>Saldo:</td>
				<td>${lista[0].cuensaldo}</td>
			</tr>
		</table>
		
		
		<table border="1">
			
			<tr>
				<th>NRO.MOV.</th>
				<th>FECHA</th>
				<th>TIPO</th>
				<th>ACCTION</th>
				<th>IMPORTE</th>
			</tr>
			
			
			<c:forEach items="${lista}" var="r">
				<tr>
					<td>${r.movinumero}</td>
					<td>${r.movifecha}</td>
					<td>${r.tipocodigo} - ${r.tiponombre}</td>
					<td>${r.tipoaccion}</td>
					<td>${r.moviimporte}</td>
				</tr>
			</c:forEach>
		
		
		</table>
		
	</c:if>
</body>
</html>