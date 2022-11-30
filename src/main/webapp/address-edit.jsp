<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<div class="center-align"><h4>Create address</h4></div>
		</c:when>
		<c:otherwise>
			<div class="center-align"><h4>Edit address #${dto.id}</h4></div>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/addresses">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
				<div class="center-align">
					<h5>Parcel data</h5>
				</div>
				<div class="row">
					<div class="input-field col s2">
						<input type="text" name="country" value="${dto.country}"> <label for="country">Country</label>
					</div>
					<div class="input-field col s2">
						<input type="text" name="town" value="${dto.town}"> <label for="town">Town</label>
					</div>
					<div class="input-field col s3">
						<input type="text" name="street" value="${dto.street}">  <label for="street">Street</label>
					</div>
					<div class="input-field col s2">
						<input type="text" name="house" value="${dto.house}"> <label for="house">House</label>
					</div>
					<div class="input-field col s2">
						<input type="text" name="flat" value="${dto.flat}"> <label for="flat">Flat</label>
					</div>
				</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/addresses"><i class="material-icons left">list</i>back</a>&nbsp;
					<button class="btn waves-effect waves-light" type="submit">
						<i class="material-icons left">save</i>Save
					</button>
			</div>
		</div>
	</form>
</t:wrapper>