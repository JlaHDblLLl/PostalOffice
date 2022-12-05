<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
<c:choose>
		<c:when test="${empty dto.id}">
			<div class="center-align"><h4>Create item</h4></div>
		</c:when>
		<c:otherwise>
			<div class="center-align"><h4>Edit item #${dto.id}</h4></div>
		</c:otherwise>
	</c:choose>
<form class="col s12" method="post" action="/items">
	<div class="row">
		<input type="hidden" name="id" value="${dto.id}" />
			<div class="center-align">
				<h5>Parcel data</h5>
			</div>
			<div class="row">
				<div class=" col s12">
					<label for="parcel_id">Parcel id</label>
					<select name="parcel_id" class="browser-default" required>
						<option value="">--select parcel--</option>
						<c:forEach items="${allParcels}" var="parcel">
							<option value="${parcel.id}" <c:if test="${parcel.id eq dto.parcel_id}">selected="selected"</c:if>>${parcel.id}: ${parcel.sender_name} ${parcel.receiver_name}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="center-align">
				<h5>Item data</h5>
			</div>
			<div class="row">
				<div class="input-field col s4">
					<input name="weight" type="number" value="${dto.weight}" required> <label
						for="weight">Weight</label>
				</div>
				<p class="center-align col s4">
					<label><input type="checkbox" name="actual" ${dto.fragile ? 'checked' : ''} value="true" /> <span>Fragile</span>
					</label>
				</p>
				<div class="input-field col s2">
					 	<input placeholder="Until what time is it good"
						name="expiration_date" type="text" value="${dto.expiration_date}" class="datepicker" required> <label
						for="expiration_date">Expiration date</label> 
				</div>
				<div class="input-field col s2">
					 	<input placeholder="Until what time is it good"
						name="expiration_date" type="text" value="${dto.expiration_date}" class="timepicker" required> <label
						for="expiration_date">Expiration time</label> 
				</div>
			</div>
			<div class="row">
				<div class="center-align">
					<h5>Item size</h5>
				</div>
				<div class="input-field col s4">
					<input name="length" type="number" value="${dto.length}" required> <label
						for="length">Length</label>
				</div>
				<div class="input-field col s4">
					<input name="width" type="number" value="${dto.width}" required> <label
						for="width">Width</label>
				</div>
				<div class="input-field col s4">
					<input name="height" type="number" value="${dto.height}" required> <label
						for="height">Height</label>
				</div>
			</div>
	</div>
	<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/items"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
</form>
</t:wrapper>