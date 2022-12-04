<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<div class="center-align"><h4>Create person</h4></div>
		</c:when>
		<c:otherwise>
			<div class="center-align"><h4>Edit person #${dto.id}</h4></div>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/userdata">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="center-align"><h5>Personal data</h5></div>
			<div class="row">
				<div class="input-field col s3">
					<input name="name" type="text" value="${dto.name}"> <label
						for="name">Name</label>
				</div>
				<div class="input-field col s3">
					<input name="surname" type="text" value="${dto.surname}"> <label
						for="surname">Surname</label>
				</div>
				<div class="input-field col s3">
					<input name="patronymic" type="text" value="${dto.patronymic}"> <label
						for="patronymic">Patronymic</label>
				</div>
				<div class="input-field col s3">
					<label for="address_id">Address id</label>
					<select name="address_id" class="browser-default" required>
						<option value="">--select address--</option>
						<c:forEach items="${allAddresses}" var="address">
							<option value="${address.id}" <c:if test="${address.id eq dto.address_id}">selected="selected"</c:if>>${address.id}: ${address.street} ${address.house}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="center-align"><h5>Passport details</h5></div>
			<div class="row">
				<div class="input-field col s4">
					<input value="KH" name="passport_number" type="number" value="${dto.passport_number}"> <label
						for="passport_number">Passport number</label>
				</div>
				<div class="input-field col s4">
					<input name="indetification_number" type="text" value="${dto.indetification_number}"> <label
						for="indetification_number">Indetification number</label>
				</div>
				<div class="input-field col s4">
					<input name="passport_authority" type="text" value="${dto.passport_authority}"> <label
						for="passport_authority">Passport authority</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/userdata"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>