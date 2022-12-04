<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="List of users" scope="application" />

<t:wrapper>
	<div class="center-align">
		<h1>All users</h1>
	</div>
	<table class="highlight">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Patronymic</th>
				<th>Address</th>
				<th>Passport_number</th>
				<th>Indetification_number</th>
				<th>Passport_authority</th>
				<th>Created</th>
				<th>Updated</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.name}" /></td>
					<td><c:out value="${entity.surname}" /></td>
					<td><c:out value="${entity.patronymic}" /></td>
					<td><c:out value="${entity.address_name}" /></td>
					<td><c:out value="${entity.passport_number}" /></td>
					<td><c:out value="${entity.indetification_number}" /></td>
					<td><c:out value="${entity.passport_authority}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.created}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.updated}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/userdata?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/userdata?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<br> <a class="btn-floating btn-large waves-effect waves-light"
					href="/userdata?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</t:wrapper>