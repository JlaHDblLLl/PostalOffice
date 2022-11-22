<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
	<div class="row">
		<form class="col s12">
			<div class="center-align"><h5>Personal data</h5></div>
			<div class="row">
				<div class="input-field col s3">
					<input id="name" type="text" class="validate"> <label
						for="name">Name</label>
				</div>
				<div class="input-field col s3">
					<input id="surname" type="text" class="validate"> <label
						for="surname">Surname</label>
				</div>
				<div class="input-field col s3">
					<input id="patronymic" type="text" class="validate"> <label
						for="patronymic">Patronymic</label>
				</div>
				<div class="input-field col s3">
					<input id="address_id" type="text" class="validate">
					<label for="address_id">Address id</label>
				</div>
			</div>
			<div class="center-align"><h5>Passport details</h5></div>
			<div class="row">
				<div class="input-field col s4">
					<input value="KH" id="passport_number" type="text" class="validate"> <label
						for="passport_number">Passport number</label>
				</div>
				<div class="input-field col s4">
					<input id="indetification_number" type="text" class="validate"> <label
						for="indetification_number">Indetification number</label>
				</div>
				<div class="input-field col s4">
					<input id="passport_authority" type="text" class="validate"> <label
						for="passport_authority">Passport authority</label>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col s12 input-field center-align">
			<a class="btn waves-effect waves-light red" href="userData-list.jsp"><i
				class="material-icons left">list</i>To list</a> <a
				class="btn waves-effect waves-light green" href="#"><i
				class="material-icons left">save</i>Save</a>
		</div>
	</div>
</t:wrapper>