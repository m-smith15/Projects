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
<title>View Character</title>
</head>
<body style="background-color: steelblue;">
	<h1>Check out this Character!</h1>
	<div class="wrapper">

		<div class="container characterContainer">
			<h2>${character.name}</h2>
			<ul class="panel">
				<li>Aerotheurge: ${character.aerotheurge_level}</li>
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

		</div>

		<div class="container learnableSpellContainer">
			<h2>Spells You Can Learn!</h2>
			<ul>
				<c:forEach var="spell" items="${spellsCharacterCanLearn }">
					<li>${spell.name}
						<ul class="learableSpells">
							<li>${spell.description }</li>
							<li>Memory Slots: ${spell.memorySlots }</li>
							<li>Resists: ${spell.resist }</li>
							<li>Scaling: ${spell.scale }</li>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<a class="btn" href="/home">Back to home?</a>
</body>
</html>