<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Postal Office manager" scope="application" />

<t:wrapper>
<div class="parallax-container">
    <div class="parallax"><img src="image.jpg" style="transform: translate3d(-50%, 100px, 0px); opacity: 1;"></div>
</div>
<div class="section">
 <div class="row">
	 <div class="section grey lighten-2 no-pad-top no-pad-bot z-depth-1 start-splash-section col s12">
		<div class = "col s12">
			<h4>Send a parcel</h4>
		</div>
	</div>
	<form>
		<div class="section grey lighten-2 no-pad-top z-depth-1 start-splash-section col s12">
			<div class="input-field col s5">
		          <input id="address_from" type="text" class="validate">
		          <label for="address_from">Address from</label>
		   	</div>
		    <div class="input-field col s5">
		          <input id="address_to" type="text" class="validate">
		          <label for="address_to">Address to</label>
		   	</div>
		    <div class="col s2">
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		    <br>
		    <a class="waves-effect btn" href="/parcels?view=edit">Calculate</a>
=======
		    <a>⠀</a>
		    <a class="waves-effect btn">Calculate</a>
>>>>>>> parent of 5d51eb5 (laba 7,8,9)
=======
		    <a>⠀</a>
		    <a class="waves-effect btn">Calculate</a>
>>>>>>> parent of 5d51eb5 (laba 7,8,9)
=======
		    <a>⠀</a>
		    <a class="waves-effect btn">Calculate</a>
>>>>>>> parent of 5d51eb5 (laba 7,8,9)
		    </div>
		</div>
	</form>
</div>
</div>
</t:wrapper>