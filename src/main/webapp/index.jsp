<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix ="t" tagdir="/WEB-INF/tags"%>

<t:wrapper>
		<h1>All parcels</h1>
		<table class="highlight">
			<thead>
				<tr>
					<th>Sender</th>
					<th>Receiver</th>
					<th>Send date/Accept date</th>
					<th>Size</th>
					<th>Weight</th>
					<th>Fragile</th>
					<th>Expiration date</th>
					<th>Address from/Address to</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><a class="dropdown-trigger" href="#!" data-target="dropdown1">Alvin<i class="material-icons center">arrow_drop_down</i></a></td>
					<td><a class="dropdown-trigger" href="#!" data-target="dropdown1">Maxim<i class="material-icons center">arrow_drop_down</i></a></td>
					<th>22.08.2022/01.09.2022</th>
					<th>10x10x10</th>
					<th>200g</th>
					<th>Yes</th>
					<th>12.08.2022-12.09.2022</th>
					<td>
					<a class="dropdown-trigger" href="#!" data-target="dropdown1">Alvin address<i class="material-icons center">arrow_drop_down</i></a>
					<a>/</a>
					<a class="dropdown-trigger" href="#!" data-target="dropdown1">Maxim address<i class="material-icons center">arrow_drop_down</i></a>
					</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="ÑÐµÐ´Ð°ÐºÑÐ¸ÑÐ¾Ð²Ð°ÑÑ" href="edit.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>
		<div class="row">
			<div class="col s12">
				<div class="center-align" >
					<br>
					<a class="btn-floating btn-large waves-effect waves-light" href="edit.jsp"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
</body>
</t:wrapper>