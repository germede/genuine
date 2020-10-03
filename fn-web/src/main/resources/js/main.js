function send(eventId) {
    let url = window.location.href + '?eventId=' + eventId;
    let xhr = new XMLHttpRequest();
    xhr.addEventListener("load", e => {handle(e.target.responseText);});
    xhr.addEventListener("error", e => { console.log(e);});
    xhr.open('GET', url, true);
    xhr.setRequestHeader('http_x_requested_with', 'true');
    xhr.send();
}

let COMMANDS_DELIMITER = '&&&';
let COMMAND_DELIMITER = '@@@';
let PARAMETER_DELIMITER = '###';

function handle(response) {
    if (response.length > 0) {
        let commands = response.split(COMMANDS_DELIMITER);
        for (let i = 0; i < commands.length; i++) {
            let command = commands[i].split(COMMAND_DELIMITER);
            execute(command[0], command[1].split(PARAMETER_DELIMITER))
        }
    }
}

function execute(command, arguments) {
    switch (command) {
        case 'CHANGE_INNER':
            getElementByXpath(arguments[0]).innerHTML = arguments[1];
            break;
        case 'APPEND_CHILD':
            getElementByXpath(arguments[0]).innerHTML += arguments[1];
            break;
        case 'TOGGLE_CLASS':
            getElementByXpath(arguments[0]).classList.toggle(arguments[1]);
            break;
    }
}

function getElementByXpath(xpath) {
    return document.evaluate(decodeURI(xpath), document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
}

function forEach(query, apply) {
    let elements = document.querySelectorAll(query);
    let element;
    for (let i = 0; i < elements.length; i++) {
        element = elements[i];
        apply(element);
    }
}
window.addEventListener('DOMContentLoaded', function() {
    const toggleSwitch = document.querySelector('input[type="checkbox"]#theme-switch');
    if (toggleSwitch) {
      toggleSwitch.addEventListener('change', function (e) {
          let dataTheme = e.target.checked ? 'dark' : 'light';
          document.documentElement.setAttribute('data-theme', dataTheme);
          localStorage.setItem('theme', dataTheme);
      });
    }
    const currentTheme = localStorage.getItem('theme');
    if (currentTheme) {
      document.documentElement.setAttribute('data-theme', currentTheme);
      if (currentTheme === 'dark') toggleSwitch.checked = true;
    }
}, true);

window.onload = function () {
    forEach('form', function(form) {
        form.addEventListener("submit", e => {
            e.preventDefault();
            var xhr = new XMLHttpRequest();
            var params = [].filter.call(form.elements, function (el) {return !(el.type in ['checkbox', 'radio']) || el.checked;})
            .filter(function(el) { return !!el.name; })
            .filter(function(el) { return !el.disabled; })
            .map(function(el) { return encodeURIComponent(el.name) + '=' + encodeURIComponent(el.value);}).join('&');
            xhr.open("POST", form.action);
            xhr.setRequestHeader('http_x_requested_with', 'true');
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhr.addEventListener("load", e => {handle(e.target.responseText);});
            xhr.addEventListener("error", e => { console.log(e);});
            xhr.send(params);
        });
    });

    forEach('.modal > .container > .close-button', function(modalCloseButton) {
        modalCloseButton.addEventListener('click', function () {
            modalCloseButton.parentElement.parentElement.classList.remove('show');
        });
    });

    forEach('.modal', function(modal) {
        window.addEventListener('click', function windowOnClick(event) {
            if (event.target === modal) modal.classList.remove('show');
        });
    });

    forEach('nav a', function(navItem) {
        if (window.location.pathname === navItem.getAttribute('href')) navItem.classList.add('active');
    });

    send('pageload');
}