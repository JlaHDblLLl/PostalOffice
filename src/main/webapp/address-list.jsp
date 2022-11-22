<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="List of address" scope="application" />

<t:wrapper>
	<div class="center-align">
		<h1>All addresses</h1>
	</div>
	<table class="highlight">
		<thead>
			<tr>
				<th>Country</th>
				<th>Town</th>
				<th>Street</th>
				<th>House</th>
				<th>Flat</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="item-edit-button" href="address-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
			<tr>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="item-edit-button" href="address-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
			<tr>
				<td>Grodno</td>
				<td>Paris</td>
				<td>KH2918923</td>
				<td>Eclair</td>
				<td>$0.87</td>
				<td><a
					class="btn-small btn-floating waves-effect waves-light blue"
					title="item-edit-button" href="address-edit.jsp"><i
						class="material-icons">edit</i></a></td>
			</tr>
		</tbody>
	</table>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<br> <a class="btn-floating btn-large waves-effect waves-light"
					href="address-edit.jsp"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
</t:wrapper>