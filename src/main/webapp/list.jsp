<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
		<h1>All postal items</h1>
		<table class="highlight">
			<thead>
				<tr>
					<th>Name</th>
					<th>Place of departure</th>
					<th>Place of acceptance</th>
					<th>Passport details</th>
					<th>Item</th>
					<th>Parcel price</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Alvin</td>
					<td>Grodno</td>
					<td>Paris</td>
					<td>KH2918923</td>
					<td>Eclair</td>
					<td>$0.87</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="ÑÐµÐ´Ð°ÐºÑÐ¸ÑÐ¾Ð²Ð°ÑÑ" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Maxim</td>
					<td>Grodno</td>
					<td>Minsk</td>
					<td>KH2311009</td>
					<td>Book</td>
					<td>$12.1</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="ÑÐµÐ´Ð°ÐºÑÐ¸ÑÐ¾Ð²Ð°ÑÑ" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Alena</td>
					<td>Grodno</td>
					<td>Moskow</td>
					<td>ÐÐ8923123</td>
					<td>Cigarettes</td>
					<td>$1.1</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="ÑÐµÐ´Ð°ÐºÑÐ¸ÑÐ¾Ð²Ð°ÑÑ" href="edit.html"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col s12">
				<div class="center-align" >
					<br>
					<a class="btn-floating btn-large waves-effect waves-light" href="edit.html"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
</t:wrapper>
