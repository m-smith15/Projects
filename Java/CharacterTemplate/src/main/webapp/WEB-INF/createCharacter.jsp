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
<title>Create Character</title>
</head>
<body style="background-color: steelblue;">

	<h1>Create a Character</h1>

	<div class="container">
		<form:form action="/character/create/new" method="post"
			modelAttribute="character">
			<form:label path="name">name:</form:label>
			<form:input path="name" type="text" />
			<form:errors path="name" />
			<br>
			<br>
			<form:label path="aerotheurge_level">aerotheurge_level:</form:label>
			<form:input path="aerotheurge_level" type="number" />
			<form:errors path="aerotheurge_level" />
			<br>
			<br>
			<form:label path="geomancer_level">geomancer_level:</form:label>
			<form:input path="geomancer_level" type="number" />
			<form:errors path="geomancer_level" />
			<br>
			<br>
			<form:label path="huntsman_level">huntsman_level:</form:label>
			<form:input path="huntsman_level" type="number" />
			<form:errors path="huntsman_level" />
			<br>
			<br>
			<form:label path="hydrosophist_level">hydrosophist_level:</form:label>
			<form:input path="hydrosophist_level" type="number" />
			<form:errors path="hydrosophist_level" />
			<br>
			<br>
			<form:label path="necromancer_level">necromancer_level:</form:label>
			<form:input path="necromancer_level" type="number" />
			<form:errors path="necromancer_level" />
			<br>
			<br>
			<form:label path="polymorph_level">polymorph_level:</form:label>
			<form:input path="polymorph_level" type="number" />
			<form:errors path="polymorph_level" />
			<br>
			<br>
			<form:label path="pyrokinetic_level">pyrokinetic_level:</form:label>
			<form:input path="pyrokinetic_level" type="number" />
			<form:errors path="pyrokinetic_level" />
			<br>
			<br>
			<form:label path="scoundrel_level">scoundrel_level:</form:label>
			<form:input path="scoundrel_level" type="number" />
			<form:errors path="scoundrel_level" />
			<br>
			<br>
			<form:label path="summoning_level">summoning_level:</form:label>
			<form:input path="summoning_level" type="number" />
			<form:errors path="summoning_level" />
			<br>
			<br>
			<form:label path="warfare_level">warfare_level:</form:label>
			<form:input path="warfare_level" type="number" />
			<form:errors path="warfare_level" />
			<br>
			<br>
			<button type="submit" class="btn">Create!</button>
		</form:form>
	</div>
	<a class="btn" href="/home">Back to home?</a>

</body>
</html>