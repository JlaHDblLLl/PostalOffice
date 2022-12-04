<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<c:set var="pageTitle" value="List of parcels" scope="application" />

<t:wrapper>
	<div class="center-align">
		<h1>All parcels</h1>
	</div>
	<table class="highlight">
		<thead>
			<tr>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="id">Id</mytaglib:sort-link></th>
				<th>Receiver</th>
				<th>Sender</th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="date_send">Date send</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="date_accept">Date accept</mytaglib:sort-link></th>
				<th>Fragile</th>
				<th>Sizes</th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="weight">Weight</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="expiration_date">Expiration date</mytaglib:sort-link></th>
				<th>Address from</th>
				<th>Address to</th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="created">Created</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="updated">Updated</mytaglib:sort-link></th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.receiver_name}" /></td>
					<td><c:out value="${entity.sender_name}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.date_send}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.date_accept}" /></td>
					<td><c:out value="${entity.fragile}" /></td>
					<td><c:out value="${entity.length}x${entity.width}x${entity.height}" /></td>
					<td><c:out value="${entity.weight}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.expiration_date}" /></td>
					<td><c:out value="${entity.address_from_name}" /></td>
					<td><c:out value="${entity.address_to_name}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.created}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.updated}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/parcels?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/parcels?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<br> <a class="btn-floating btn-large waves-effect waves-light"
					href="parcels?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</t:wrapper>
