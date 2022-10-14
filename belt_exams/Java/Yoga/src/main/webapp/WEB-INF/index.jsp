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
	<link rel="stylesheet" href="/css/style.css">
	<!-- change to match your file/naming structure -->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Home page</title>
</head>
<body style="background-color:steelblue;">
	<h1>Look at this login and registration page</h1>

	<div class="container">
		<h1>Registration</h1>
		<c:out value="${errorRegister}"/>
		<form:form action="/register" method="post" modelAttribute="newUser">
			<form:label path="first_name">First Name: </form:label> 
			<form:input type="text" path="first_name"/> 
			<form:errors path="first_name"/><br>
			<form:label path="last_name">Last Name: </form:label> 
			<form:input type="text" path="last_name"/>
			<form:errors path="last_name"/><br> 
			<form:label path="email">Email: </form:label> 
			<form:input type="text" path="email"/>
			<form:errors path="email"/><br> 
			<form:label path="password">Password: </form:label> 
			<form:input type="text" path="password"/>
			<form:errors path="password"/><br> 
			<form:label path="confirm_password">Confirm Password: </form:label>
			<form:input type="text" path="confirm_password"/>
			<form:errors path="confirm_password"/><br> 
			<button type="submit">Register!</button>
		</form:form>
	</div>
	<hr>
	<br>
	<div class="container">
		<h1>Login</h1>
		<c:out value="${errorLogin}"/>
		<form:form action="/login" method="post" modelAttribute="user">
			<form:label path="email">Email:</form:label> 
			<form:input path="email" type="text"/>
			<form:errors path="email"/><br>
			<form:label path="password">Password:</form:label> 
			<form:input path="password" type="text"/> 
			<form:errors path="password"/><br>
			<button type="submit">Login!</button>
		</form:form>
	</div>
</body>
</html>