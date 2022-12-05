document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.dropdown-trigger');
    var instances = M.Dropdown.init(elems, {});
  });
 document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, {});
  });
  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.parallax');
    var instances = M.Parallax.init(elems, {});
  });
  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.datepicker');
    var instances = M.Datepicker.init(elems, {format:"yyyy-mm-dd"});
  });
  document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.timepicker');
    var instances = M.Timepicker.init(elems, {twelveHour:false});
  });
 document.addEventListener('DOMContentLoaded', function() {
		M.FormSelect.init(document.querySelectorAll('select'), {});
});
function sendHTTPDelete(url) {
	fetch(window.location.origin + url, {
		method: 'DELETE',
	}).then(() => {
		window.location.reload()
	});
}