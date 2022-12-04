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
<nav class="deep-purple lighten-2" role="navigation">
	
	<ul id="about_dropdown" class="dropdown-content">
		<li><a href="#!">Company</a></li>
		<li><a href="#!">Contacts</a></li>
		<li><a href="#!">Our policy</a></li>
	</ul>
	<ul id="mobile_about_dropdown" class="dropdown-content">
		<li><a href="#!">Company</a></li>
		<li><a href="#!">Contacts</a></li>
		<li><a href="#!">Our policy</a></li>
	</ul>
	
	<div class="nav-wrapper container">
		<a id="logo-container" href="index.jsp" class="brand-logo center">PostalOfficeGrodno</a>
		<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i
			class="material-icons">menu</i></a>
		<ul class="left hide-on-med-and-down">
			<li><a href="parcels">Parcels</a></li>
			<li><a href="items">Items</a></li>
			<li><a href="userdata">User data</a></li>
		</ul>
		<ul class="right hide-on-med-and-down">
			<li><a href="addresses">Addresses</a></li>
			<li><a class="dropdown-trigger" href="#!" data-target="about_dropdown">About<i class="material-icons right">arrow_drop_down</i></a></li>
			<li><a onclick="sendHTTPDelete('/login')">Logout</a></li>
		</ul>
	</div>
	
	<ul class="sidenav" id="mobile-demo">
		<li><a href="parcels">Parcels</a></li>
		<li><a href="items">Items</a></li>
		<li><a href="userdata">User data</a></li>
		<li><a href="addresses">Addresses</a></li>
		<li><a class="dropdown-trigger" href="#!" data-target="mobile_about_dropdown">About<i class="material-icons right">arrow_drop_down</i></a></li>
		<li><div class="divider"></div></li>
		<li class="active"><a onclick="sendHTTPDelete('/login')">Logout</a></li>
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