<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="List of address" scope="application" />

<t:wrapper>
	<div class="center-align">
		<h1>All addresses</h1>
	</div>
	<table class="highlight">
		<thead>
			<tr>
				<th>Address id</th>
				<th>Country</th>
				<th>Town</th>
				<th>Street</th>
				<th>House</th>
				<th>Flat</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.country}" /></td>
					<td><c:out value="${entity.town}" /></td>
					<td><c:out value="${entity.street}" /></td>
					<td><c:out value="${entity.house}" /></td>
					<td><c:out value="${entity.flat}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/addresses?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/addresses?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<br> <a class="btn-floating btn-large waves-effect waves-light"
					href="/addresses?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</t:wrapper>