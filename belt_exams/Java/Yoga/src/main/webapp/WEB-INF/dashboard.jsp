<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>THE DASH</title>
</head>
<body style="background-color: steelblue;">
	<h1>
		Welcome
		<c:out value="${first_name}" />
		<c:out value="${last_name}" />
	</h1>
	<h1>
		Your ID is
		<c:out value="${id}" />
		and your email is
		<c:out value="${email}" />
	</h1>

	<table style="background-color: seagreen;">
		<tr>
			<th>Course Name</th>
			<th>Instructor</th>
			<th>Day</th>
			<th>Price</th>
			<th>Time</th>
		</tr>
		<c:forEach var="item" items="${courses}">
			<tr>
				<td><a href="/course/view/${item.id}">${item.name}</a> 
				<c:if test="${id == item.user.id}">
						<a class="btn" style="border: solid 2px black"
							href="/course/edit/${item.id}">Edit Entry?</a>
					</c:if> |</td>
				<td>${item.user.first_name}|</td>
				<td>${item.day_of_week }|</td>
				<td>${item.price}|</td>
				<td>${item.time}</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<br>
	<a class="btn" href="/course/new">New Course?</a>
	<hr>
	<br>
	<a class="btn" href="/logout">Logout?</a>
</body>
</html>