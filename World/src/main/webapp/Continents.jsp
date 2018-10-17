<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I continenti</title>
</head>
<body>
	<form action="cities/search">
		<input type="text" name="city_Name" placeholder="inserisci nome">
		<button type="submit">Search</button>
	</form>
	<div align="center" style="margin-top: 50 px;">
		<c:forEach items="${listaContinenti}" var="continente">
			<a href="countries?continent=${continente}">${continente}</a>
			<br>
		</c:forEach>
	</div>
</body>
</html>