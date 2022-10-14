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
	<title>single course</title>
</head>
<body style="background-color:steelblue;">
<h1>User ${first_name} with ID of ${user.id}</h1>

<div class="container">
	<form:form action="/course/edit/${course.id}" method="post" modelAttribute="course">
	<input type="hidden" name="_method" value="put"/>
		<form:label path="name">name:</form:label>
		<form:input path="name" type="text" value="${course.name}" />
		<form:errors path="name" /><br>
		<br>
		<form:label path="day_of_week">day:</form:label>
		<form:input path="day_of_week" type="text" value="${course.day_of_week}"/>
		<form:errors path="day_of_week" /><br>
		<br>
		<form:label path="price">price:</form:label>
		<form:input path="price" type="number" value="${course.price}"/>
		<form:errors path="price" /><br>
		<br>
		<form:label path="time">time:</form:label>
		<form:input path="time" type="text" value="${course.time}" />
		<form:errors path="time" /><br>
		<br>
		<form:label path="description">description:</form:label>
		<form:textarea path="description" value="${course.description}" />
		<form:errors path="description" /><br>
		
		 <form:input type="hidden" path="user" value="${user.id}"/>
		<button type="submit">Edit!</button>
	</form:form>
</div>

<hr><br>
<a class="btn" href="/dashboard">Back 2 Dash?</a>

<hr><br>
<form:form action="/course/delete/${course.id}" method="post">
	<input type="hidden" name="_method" value="delete">
	<button type="submit">Delete?</button>
</form:form>

</body>
</html>