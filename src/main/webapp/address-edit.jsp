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
				<div class="input-field col s3">
					<input id="country" type="text" class="validate"> <label
						for="country">Country</label>
				</div>
				<div class="input-field col s3">
					<input id="town" type="text" class="validate"> <label
						for="town">Town</label>
				</div>
				<div class="input-field col s3">
					<input id="street" type="text" class="validate"> <label
						for="street">Street</label>
				</div>
				<div class="input-field col s3">
					<input id="house flat" type="text" class="validate"> <label
						for="house flat">House and flat</label>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col s12 input-field center-align">
			<a class="btn waves-effect waves-light red" href="address-list.jsp"><i
				class="material-icons left">list</i>To list</a> <a
				class="btn waves-effect waves-light green" href="#"><i
				class="material-icons left">save</i>Save</a>
		</div>
	</div>
</t:wrapper>