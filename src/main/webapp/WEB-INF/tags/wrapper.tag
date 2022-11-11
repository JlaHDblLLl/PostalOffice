<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title><c:out value="${pageTitle}" /></title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<script src="sample.js"></script>
<nav class="light-blue lighten-1" role="navigation">
	<ul id="dropdown1" class="dropdown-content">
		<li><a href="#!">one</a></li>
		<li><a href="#!">two</a></li>
		<li><a href="#!">three</a></li>
	</ul>
	<div class="nav-wrapper container">
		<a id="logo-container" href="index.jsp" class="brand-logo center">PostalOficeGrodno</a>
		<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
		<ul class="left hide-on-med-and-down">
			<li><a href="#">Parcels</a></li>
			<li><a href="#">User data</a></li>
			<li><a class="dropdown-trigger" href="#!"
				data-target="dropdown1">About<i class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a href="#">Login</a></li>
			<li><a href="#"><i class="material-icons right">perm_identity</i>Sign
					in</a></li>
		</ul>
	</div>
	<ul class="sidenav" id="mobile-demo">
		<li><a href="#">Parcels</a></li>
		<li><a href="#">User data</a></li>
		<li><a class="dropdown-trigger" href="#!" data-target="dropdown1">About<i
				class="material-icons right">arrow_drop_down</i></a></li>
		<li class="divider"></li>
		<li><a href="#">Login</a></li>
		<li><a href="#"><i class="material-icons right">perm_identity</i>Sign
				in</a></li>
	</ul>
</nav>
<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<jsp:doBody />
		<!-- Page body will be here -->
	</div>
</div>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>