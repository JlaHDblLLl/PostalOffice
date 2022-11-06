<html>

<head>
<title>Edit item</title>

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
		<h1>Postal item</h1>
		<div class="row">
			<form class="col s12">
				<h5>Personal data</h5>
				<div class="row">
					<div class="input-field col s6">
						<input id="first_name" type="text" class="validate"> <label for="first_name">First Name</label>
					</div>
					<div class="input-field col s6">
						<input id="last_name" type="text" class="validate"> <label for="last_name">Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s6">
						<input id="place_of_departure" type="text" class="validate"> <label for="place_of_departure">Place of departure</label>
					</div>
					<div class="input-field col s6">
						<input id="place_of_acceptance" type="text" class="validate"> <label for="place_of_acceptance">Place of acceptance</label>
					</div>
				</div>
				<h5>Passport details</h5>
				<div class="row">
					<div class="input-field col s6">
						<input id="pasport_KH" type="text" class="validate"> <label for="pasport_KH">KH</label>
					</div>
					<div class="input-field col s6">
						<input id="pasport_id" type="text" class="validate"> <label for="pasport_id">ID</label>
					</div>
				</div>
				<h5>Item info</h5>
				<div class="row">
					<div class="input-field col s4">
						<input id="item_name" type="password" class="validate"> <label for="item_name">Name</label>
					</div>
					<div class="input-field col s4">
						<input id="item_weight" type="password" class="validate"> <label for="item_weight">Weight</label>
						<span class="helper-text" data-error="wrong" data-success="right">In killos</span>
					</div>
					<div class="input-field col s4">
						<input id="item_price" type="password" class="validate"> <label for="item_price">Price</label>
						<span class="helper-text" data-error="wrong" data-success="right">In $</span>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="email" type="email" class="validate"> <label for="email">Email</label>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="list.html"><i class="material-icons left">list</i>To list</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
			</div>
		</div>
	</div>
</div>

<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
