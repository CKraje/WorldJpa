<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="insert_modify">
		<!-- http://localhost:8080/WorldProject/insert-modify -->
		City Name:<br> <input type="text" name="city_name"
			value="${city.name}"> <select name="theCountries">
			<!-- value = '${city.name} -->
			<c:forEach items="${ lista_Countriees}" var="countriees">
				<option ${paese == countriees.code ? "selected":"" }
					value="${countriees.code}">${countriees.name}</option>
			</c:forEach>
		</select> <br> <br> District Name:<br> <input type="text"
			name="district_name" value="${city.district}"> <br> <br>
		Population's Number:<br> <input type="text" name="population"
			value="${city.population}"> <input type="hidden"
			name="city_id" value="${city.id}">
		<!-- value="${cityId}"-->

		<button type="submit">Crea/Modifica</button>
	</form>
	<a href="../continents"><button>Continenti</button></a>
	<br>
	<br>
	<p>${message}</p>
	<c:if test="${not empty definitionCreate}">
		<c:out value="${definitionCreate}" />
		<c:out value="${identificativo}" />
	</c:if>
	<c:if test="${not empty definitionUpdate}">
		<c:out value="${definitionUpdate}" />
		<c:out value="${identificativo}" />
	</c:if>
</body>
</html>