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
					<input name="weight" type="text" value="${dto.weight}"> <label
						for="weight">Weight</label>
				</div>
				<div class="input-field col s4">
					<input placeholder="Until what time is it good"
						name="expiration_date" type="text" value="${dto.expiration_date}" class="datepicker"> <label
						for="expiration_date">Expiration date</label>
				</div>
				<p class="center-align col s4">
					<label> <input value="${dto.fragile}" type="checkbox" /><span>Fragile</span>
					</label>
				</p>
			</div>
			<div class="row">
			<div class="input-field col s2">
					<input name="address_from_id" type="text" value="${dto.address_from_id}"> <label
						for="address_from_id">Address from id</label>
				</div>
				<div class="input-field col s2">
					<input name="address_to_id" type="text" value="${dto.address_to_id}"> <label
						for="address_to_id">Address to id</label>
				</div>
				<div class="input-field col s2">
					<input name="receiver_id" type="text" value="${dto.receiver_id}"> <label
						for="receiver_id">Receiver id</label>
				</div>
				<div class="input-field col s2">
					<input name="sender_id" type="text" value="${dto.sender_id}"> <label
						for="date_send">Sender id</label>
				</div>
				<div class="input-field col s2">
					<input name="date_send" value="${dto.date_send}" type="text" class="datepicker"> <label
						for="date_send">Date send</label>
				</div>
				<div class="input-field col s2">
					<input name="date_accept" value="${dto.date_accept}" type="text" class="datepicker"> <label
						for="date_accept">Date accept</label>
				</div>
			</div>
			<div class="row">
				<div class="center-align">
					<h5>Size</h5>
				</div>
				<div class="input-field col s4">
					<input name="length"  value="${dto.length}" type="text"> <label
						for="length">Length</label>
				</div>
				<div class="input-field col s4">
					<input name="width" value="${dto.width}" type="text"> <label
						for="width">Width</label>
				</div>
				<div class="input-field col s4">
					<input name="height" value="${dto.height}" type="text"> <label
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