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
	<div class="nav-wrapper container">
		<a id="logo-container" href="index.html" class="brand-logo center">PostalOficeGrodno</a>
		<ul class="left hide-on-med-and-down">	
			<li><a href="#">Parcels</a></li>
			<li><a href="#">User data</a></li>
			<li><a class="dropdown-trigger" href="#!" data-target="dropdown1">Settings<i class="material-icons right">arrow_drop_down</i></a></li>
		</ul>
		<ul class="right hide-on-med-and-down">	
			<li><a href="#">Login</a></li>
			<li><a href="#"><i class="material-icons right">perm_identity</i>Sign in</a></li>
		</ul>
	</div>
</nav>


<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<h1>All postal items</h1>
		<table class="highlight">
			<thead>
				<tr>
					<th>Name</th>
					<th>Place of departure</th>
					<th>Place of acceptance</th>
					<th>Passport details</th>
					<th>Item</th>
					<th>Parcel price</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Alvin</td>
					<td>Grodno</td>
					<td>Paris</td>
					<td>KH2918923</td>
					<td>Eclair</td>
					<td>$0.87</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Maxim</td>
					<td>Grodno</td>
					<td>Minsk</td>
					<td>KH2311009</td>
					<td>Book</td>
					<td>$12.1</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Alena</td>
					<td>Grodno</td>
					<td>Moskow</td>
					<td>КН8923123</td>
					<td>Cigarettes</td>
					<td>$1.1</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col s12">
				<div class="center-align" >
					<br>
					<a class="btn-floating btn-large waves-effect waves-light" href="edit.html"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
