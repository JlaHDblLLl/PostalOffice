<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
	<div class="row">
		<form class="col s12">
			<div class="center-align">
				<h5>Parcel data</h5>
			</div>
			<div class="row">
				<div class="input-field col s4">
					<input id="weight" type="text" class="validate"> <label
						for="weight">Weight</label>
				</div>
				<div class="input-field col s4">
					<input placeholder="Until what time is it good"
						id="expiration_date" type="text" class="datepicker"> <label
						for="expiration_date">Expiration date</label>
				</div>
				<p class="center-align col s4">
					<label> <input type="checkbox" /><span>Fragile</span>
					</label>
				</p>
			</div>
			<div class="row">
			<div class="input-field col s2">
					<input id="address_from_id" type="text" class="validate"> <label
						for="address_from_id">Address from id</label>
				</div>
				<div class="input-field col s2">
					<input id="address_to_id" type="text" class="validate"> <label
						for="address_to_id">Address to id</label>
				</div>
				<div class="input-field col s2">
					<input id="receiver_id" type="text" class="validate"> <label
						for="receiver_id">Receiver id</label>
				</div>
				<div class="input-field col s2">
					<input id="sender_id" type="text" class="validate"> <label
						for="date_send">Sender id</label>
				</div>
				<div class="input-field col s2">
					<input id="date_send" type="text" class="datepicker"> <label
						for="date_send">Date send</label>
				</div>
				<div class="input-field col s2">
					<input id="date_accept" type="text" class="datepicker"> <label
						for="date_accept">Date accept</label>
				</div>
			</div>
			<div class="row">
				<div class="center-align">
					<h5>Size</h5>
				</div>
				<div class="input-field col s4">
					<input id="length" type="text" class="validate"> <label
						for="length">Length</label>
				</div>
				<div class="input-field col s4">
					<input id="width" type="text" class="validate"> <label
						for="width">Width</label>
				</div>
				<div class="input-field col s4">
					<input id="height" type="text" class="validate"> <label
						for="height">Height</label>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col s12 input-field center-align">
			<a class="btn waves-effect waves-light red" href="parcel-list.jsp"><i
				class="material-icons left">list</i>To list</a> <a
				class="btn waves-effect waves-light green" href="#"><i
				class="material-icons left">save</i>Save</a>
		</div>
	</div>
</t:wrapper>