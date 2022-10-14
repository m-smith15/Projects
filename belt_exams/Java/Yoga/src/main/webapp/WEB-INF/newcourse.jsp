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
	<title>new course</title>
</head>
<body style="background-color:steelblue;">
<h1>User ${first_name} with ID of ${id}</h1>

<div class="container">
	<form:form action="/course/new/create" method="post" modelAttribute="course">
		<form:label path="name">name:</form:label>
		<form:input path="name" type="text" />
		<form:errors path="name" /><br>
		<br>
		<form:label path="day_of_week">day:</form:label>
		<form:input path="day_of_week" type="text" />
		<form:errors path="day_of_week" /><br>
		<br>
		<form:label path="price">price:</form:label>
		<form:input path="price" type="number" />
		<form:errors path="price" /><br>
		<br>
		<form:label path="time">time:</form:label>
		<form:input path="time" type="text" />
		<form:errors path="time" /><br>
		<br>
		<form:label path="description">description:</form:label>
		<form:textarea path="description" />
		<form:errors path="description" /><br>
		
		 <form:input type="hidden" path="user" value="${id}"/>
		<button type="submit">Create!</button>
	</form:form>
</div>

<hr><br>
<a class="btn" href="/dashboard">Back 2 Dash?</a>
</body>
</html>