<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I paesi</title>
</head>
<body>
	<div align="center" style="margin-top: 50 px;">
		<form action="continents">
			<c:forEach items="${countries}" var="country">
				<a href="cities/list?country_code=${country.code}">${country.name}</a>
				<br>
			</c:forEach>
			<br> <br>
			<button type="submit" value="submit">Indietro</button>
		</form>
		<!--  <br> <br>
		<button type="submit" value="submit">Indietro</button> -->
	</div>

</body>
</html>