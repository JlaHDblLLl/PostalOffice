<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="List of parcels" scope="application" />

<t:wrapper>
	<div class="center-align">
		<h1>All parcels</h1>
	</div>
	<table class="highlight">
		<thead>
			<tr>
				<th>Receiver</th>
				<th>Sender</th>
				<th>Date send</th>
				<th>Date accept</th>
				<th>Fragile</th>
				<th>Sizes</th>
				<th>Weight</th>
				<th>Expiration date</th>
				<th>Address from</th>
				<th>Address to</th>
				<th>Created</th>
				<th>Updated</th>	
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="parcel-edit-button" href="parcel-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
			<tr>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="parcel-edit-button" href="parcel-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
			<tr>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Alvin</td>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="parcel-edit-button" href="parcel-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
		</tbody>
	</table>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<br> <a class="btn-floating btn-large waves-effect waves-light"
					href="parcel-edit.jsp"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</t:wrapper>
