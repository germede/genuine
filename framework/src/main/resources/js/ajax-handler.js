document.addEventListener('DOMContentLoaded', function (ev) {
    var as = document.getElementsByTagName("a");
    for (var i = 0; i < as.length; i++) {
        as[i].addEventListener("click", function (ev) {
            ev.preventDefault();
            console.log("asdf");
        });
    }
}, false);