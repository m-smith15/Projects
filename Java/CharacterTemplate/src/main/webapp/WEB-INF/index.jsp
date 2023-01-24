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
<title>Character Builder</title>
</head>
<body>
<h1>Divinity Original Sin 2 Character Builder</h1>
<hr>

	<h1>Select from a list of characters already created:</h1>
	<div class="container characterContainer">
		<c:forEach var="character" items="${characters }">
			<c:out value="${character.name}" />
			<br>
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
			<a class="btn" href="/character/view/${character.id}">View Character?</a>
		</c:forEach>
	</div>
	<div class="newCharBtn">
	<a class="btn" href="/character/create">Create a new character?</a>
	</div>
	<hr>
	<h1 class="wrapperHeader">Here are the spells scraped from the Divinity Original Sin 2 Wiki</h1>
	<div class="acknoledgements">
	<p>All Spell data here was scraped using a <a href="https://github.com/m-smith15/Projects/tree/master/Java/WebScraper2">web scraper</a> that scraped the DOS2 wiki! Some of the data is incomplete, so bear with me while I continue to fine-tune.<br>
A big thank you to the folks at <a href="https://divinityoriginalsin2.wiki.fextralife.com/Divinity+Original+Sin+2+Wiki">The Divinity Original Sin 2 Wiki</a>
who built, contributed, and have maintained the wiki I pulled the data from!
</p>
</div>
	<div class="wrapper">
		<c:forEach var="school" items="${schools}">
			<div class="container">
				<b>${school}</b>
				<details class="allSchoolSpells">
				<c:set var="varA" value="${school}" />
				<c:forEach var="spell" items="${spells}">
					<ul>
						<c:if test="${spell.school == pageContext.getAttribute('varA')}">
							<li><c:out value="${spell.name}" />: <c:out
									value="${spell.description }" />
								<ul>
									<li>Skill Level: <c:out value="${spell.requiredLevel}" /></li>
									<li>Memory: <c:out value="${spell.memorySlots}" /></li>
								</ul></li>
						</c:if>
					</ul>
				</c:forEach>
				</details>
			</div>
		</c:forEach>
	</div>
</body>
</html>