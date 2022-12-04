<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit page" scope="application" />

<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<div class="center-align"><h4>Create parcel</h4></div>
		</c:when>
		<c:otherwise>
			<div class="center-align"><h4>Edit parcel #${dto.id}</h4></div>
		</c:otherwise>
	</c:choose>
	
<form class="col s12" method="post" action="/parcels">
	<div class="row">
		<input type="hidden" name="id" value="${dto.id}" />
			<div class="center-align">
				<h5>Parcel data</h5>
			</div>
			<div class="row">
				<div class="input-field col s4">
					<input name="weight" type="text" value="${dto.weight}" required> <label
						for="weight">Weight</label>
				</div>
				<div class="input-field col s4">
					<input placeholder="Until what time is it good"
						name="expiration_date" type="text" value="${dto.expiration_date}" class="datepicker" required> <label
						for="expiration_date">Expiration date</label>
				</div>
				<p class="center-align col s4">
					<label><input type="checkbox" name="checkbox" ${dto.fragile ? 'fragile' : ''} value="true" /> <span>Fragile</span>
					</label>
				</p>
			</div>
			<div class="row">
			<div class="col s2">
			<label for="address_from_id">Address from</label>
				<select name="address_from_id" class="browser-default" required>
						<option value="">--select address of sender--</option>
						<c:forEach items="${allAddresses}" var="address">
							<option value="${address.id}" <c:if test="${address.id eq dto.address_from_id}">selected="selected"</c:if>>${address.id}: ${address.street} ${address.house}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col s2">
					<label for="address_to_id">Address to</label>
					<select name="address_to_id" class="browser-default" required>
						<option value="">--select address of receiver--</option>
						<c:forEach items="${allAddresses}" var="address">
							<option value="${address.id}" <c:if test="${address.id eq dto.address_to_id}">selected="selected"</c:if>>${address.id}: ${address.street} ${address.house}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col s2">
					<label for="receiver_id">Receiver id</label>
					<select name="receiver_id" class="browser-default" required>
						<option value="">--select receiver--</option>
						<c:forEach items="${allUserdata}" var="userdata">
							<option value="${userdata.id}" <c:if test="${userdata.id eq dto.receiver_id}">selected="selected"</c:if>>${userdata.id}: ${userdata.name} ${userdata.indetification_number}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col s2">
					<label for="sender_id">Sender id</label>
					<select name="sender_id" class="browser-default" required>
						<option value="">--select sender--</option>
						<c:forEach items="${allUserdata}" var="userdata">
							<option value="${userdata.id}" <c:if test="${userdata.id eq dto.receiver_id}">selected="selected"</c:if>>${userdata.id}: ${userdata.name} ${userdata.indetification_number}</option>
						</c:forEach>
					</select>
				</div>
				<div class="input-field col s2">
					<input name="date_send" value="${dto.date_send}" type="text" class="datepicker" required> <label
						for="date_send">Date send</label>
				</div>
				<div class="input-field col s2">
					<input name="date_accept" value="${dto.date_accept}" type="text" class="datepicker" required> <label
						for="date_accept">Date accept</label>
				</div>
			</div>
			<div class="row">
				<div class="center-align">
					<h5>Size</h5>
				</div>
				<div class="input-field col s4">
					<input name="length"  value="${dto.length}" type="text" required> <label
						for="length">Length</label>
				</div>
				<div class="input-field col s4">
					<input name="width" value="${dto.width}" type="text" required> <label
						for="width">Width</label>
				</div>
				<div class="input-field col s4">
					<input name="height" value="${dto.height}" type="text" required> <label
						for="height">Height</label>
				</div>
			</div>
	</div>
	<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/parcels"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
</form>
</t:wrapper>