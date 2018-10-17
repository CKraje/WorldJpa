<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le citta</title>
</head>
<body>
	<!--<c:if test="${!empty countryCode }">-->
	<a href="create-modify?idCity=${0}&countryCode=${countryCode}"><button
			type="submit" value="">Crea città</button></a>
	<!--</c:if>-->
	<div align="center" style="margin-top: 50 px;">
		<c:forEach items="${lista_cities}" var="cities">
			<a href="delete?countryCode=${cities.code}&idCity=${cities.id}">
				elimina</a>
			<c:out value="${cities.name}" />
			<c:out value="${cities.population}" />
			<a
				href="create-modify?countryCode=${cities.code}&idCity=${cities.id}">
				modifica </a> 
			<br>
		</c:forEach>
		<br> <br>
		<h1>${delete_message}</h1>
		<c:if test="${!empty continent }">
			<a href="../countries?continent=${continent}"><button
					type="submit">Indietro</button></a>
		</c:if>
		<a href="../continents"><button>Continenti</button></a> <br> <br>
	</div>
</body>
</html>