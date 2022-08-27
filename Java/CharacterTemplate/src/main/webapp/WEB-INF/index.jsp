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
<title>Home</title>
</head>
<body style="background-color: steelblue;">

	<h1>Select from a list of characters already created:</h1>
	<div class="container" style="background-color:cadetblue;">
		<c:forEach var="character" items="${characters }">
			<c:out value="${character.name}" /> <a href="/character/view/${character.id}">View Character?</a>
			<br>
			<ul class="panel">
				<li>Aerotheurge:${character.aerotheurge_level}</li>
				<li>Geomancer: ${character.geomancer_level}</li>
				<li>Huntsman: ${character.huntsman_level}</li>
				<li>Hydrosophist: ${character.hydrosophist_level}</li>
				<li>Necromancer: ${character.necromancer_level}</li>
				<li>Polymorph: ${character.polymorph_level}</li>
				<li>Pyrokinectic: ${character.pyrokinetic_level}</li>
				<li>Scoundrel: ${character.scoundrel_level}</li>
				<li>Summoning: ${character.summoning_level}</li>
				<li>Warfare: ${character.warfare_level}</li>
			</ul>
		</c:forEach>
	</div>
	<a class="btn" style="border: solid black 1px" href="/character/create">Tryna
		Craft?</a>
	<hr>
	<h1>Just look at these spells</h1>
	<div class="wrapper">
		<c:forEach var="school" items="${schools}">
			<div class="container">
				<b>${school}</b>
				<c:set var="varA" value="${school}" />
				<c:forEach var="spell" items="${spells}">
					<ul>
						<c:if test="${spell.school == pageContext.getAttribute('varA')}">
							<li><c:out value="${spell.name}" /> |: <c:out
									value="${spell.description }" />
								<ul>
									<li>Skill Level: <c:out value="${spell.requiredLevel}" /></li>
									<li>Memory: <c:out value="${spell.memorySlots}" /></li>
								</ul></li>
						</c:if>
					</ul>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
</body>
</html>