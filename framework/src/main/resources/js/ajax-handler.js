function loadPage() {
    var placeholder = document.getElementById("ajax-placeholder");
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status >= 200 || this.status < 300)) {
            placeholder.innerHTML = this.responseText;
            setOnClickListeners();
        }
    };
    xhttp.open("GET", window.location.href, true);
    xhttp.setRequestHeader("http_x_requested_with", "true");
    xhttp.send();
}

function setOnClickListener(ev) {
    ev.preventDefault();
    var newLocation = this.getAttribute("href");
    history.pushState(null, null, newLocation);
    loadPage();
}

function setOnClickListeners() {
    var as = document.getElementsByTagName("a");
    for (var i = 0; i < as.length; i++) {
        as[i].onclick = setOnClickListener;
    }
}

window.addEventListener('popstate', function (event) {
    loadPage();
}, false);

document.addEventListener('DOMContentLoaded', setOnClickListeners, false);
