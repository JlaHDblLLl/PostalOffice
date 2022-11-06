<html>
<head>
<title>Postal Office manager</title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<script src="sample.js"></script>
<body>
<nav class="light-blue lighten-1" role="navigation">
	<ul id="dropdown1" class="dropdown-content">
  <li><a href="#!">one</a></li>
  <li><a href="#!">two</a></li>
  <li><a href="#!">three</a></li>
</ul>
	<div class="nav-wrapper container">
		<a id="logo-container" href="index.jsp" class="brand-logo center">PostalOficeGrodno</a>
		<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
		<ul class="left hide-on-med-and-down">	
			<li><a href="#">Parcels</a></li>
			<li><a href="#">User data</a></li>
			<li><a class="dropdown-trigger" href="#!" data-target="dropdown1">About<i class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
		<ul class="right hide-on-med-and-down">	
			<li><a href="#"><% java.util.Date date = new java.util.Date(); out.print(date.toString()); %></a></li>
			<li><a href="#">Login</a></li>
			<li><a href="#"><i class="material-icons right">perm_identity</i>Sign in</a></li>
		</ul>
	</div>
<ul class="sidenav" id="mobile-demo">	
	<li><a href="#">Parcels</a></li>
	<li><a href="#">User data</a></li>
	<li><a class="dropdown-trigger" href="#!" data-target="dropdown1">About<i class="material-icons right">arrow_drop_down</i></a></li>
	<li class="divider"></li>
	<li><a href="#">Login</a></li>
	<li><a href="#"><i class="material-icons right">perm_identity</i>Sign in</a></li>
</ul>
</nav>


<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<h1>All parcels</h1>
		<table class="highlight">
			<thead>
				<tr>
					<th>Sender</th>
					<th>Receiver</th>
					<th>Send date/Accept date</th>
					<th>Size</th>
					<th>Weight</th>
					<th>Fragile</th>
					<th>Expiration date</th>
					<th>Address from/Address to</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a class="dropdown-trigger" href="#!" data-target="dropdown1">Alvin<i class="material-icons center">arrow_drop_down</i></a></td>
					<td><a class="dropdown-trigger" href="#!" data-target="dropdown1">Maxim<i class="material-icons center">arrow_drop_down</i></a></td>
					<th>22.08.2022/01.09.2022</th>
					<th>10x10x10</th>
					<th>200g</th>
					<th>Yes</th>
					<th>12.08.2022-12.09.2022</th>
					<td>
					<a class="dropdown-trigger" href="#!" data-target="dropdown1">Alvin address<i class="material-icons center">arrow_drop_down</i></a>
					<a>/</a>
					<a class="dropdown-trigger" href="#!" data-target="dropdown1">Maxim address<i class="material-icons center">arrow_drop_down</i></a>
					</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="edit.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col s12">
				<div class="center-align" >
					<br>
					<a class="btn-floating btn-large waves-effect waves-light" href="edit.jsp"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="sample.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>



</body>
</html>