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
<body style="background-color: steelblue;">
	<h1>check out this single course called ${course.name} with
		${course.user.first_name}</h1>

	<h3>Day: ${course.day_of_week}</h3>
	<br>
	<h3>Price: ${course.price}</h3>
	<br>
	<h3>Time: ${course.time}</h3>
	<br>
	<h3>Description: ${course.description}</h3>
	<br>
	<hr>
	<br>
	<a class="btn" href="/dashboard">Back 2 Dash?</a>

	<hr>
	<br>
	<h1>Students:</h1>
	<ul>
		<c:forEach var="student" items="${students}">
			<c:if test="${student.course.id == course.id}">
				<li>${student.name}- ${student.email}</li>
			</c:if>
		</c:forEach>
	</ul>
	<hr>
	<br>
	<div class="container">
		<h1>Add new Student?</h1>
		<form:form action="/student/new/create" method="post" modelAttribute="student">
			<form:label path="name">name:</form:label>
			<form:input path="name" type="text" />
			<form:errors path="name" />
			<br>
			<br>
			<form:label path="email">email:</form:label>
			<form:input path="email" type="text" />
			<form:errors path="email" />
			<br>
			<br>

			<form:input type="hidden" path="user" value="${user.id}" />
			<form:input type="hidden" path="course" value="${course.id}" />
			<button type="submit">Create!</button>
		</form:form>
	</div>

	<div class="container">
		<h1>Existing Student?</h1>
		<form:form action="/student/current/add/${course.id}" method="post" modelAttribute="existingStudent">
		<input type="hidden" name="_method" value="put"/>
			<form:select path="id">
				<c:forEach var="student" items="${students}">
					<form:option value="${student.id}" path="id">
						<c:out value="${student.name} ${student.email}" />
					</form:option>
				</c:forEach>
			</form:select>

			<form:input type="hidden" path="user" value="${user.id}" />
			<form:input type="hidden" path="course" value="${course.id}" />
			<button type="submit">Add 2 Course!</button>
		</form:form>
	</div>

</body>
</html>