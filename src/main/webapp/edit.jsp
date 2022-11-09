<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>

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
</t:wrapper>