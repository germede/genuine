function send(eventId) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && (this.status >= 200 || this.status < 300)) {
            handle(this.responseText);
        }
    };
    let url = window.location.href + '?eventId=' + eventId;
    xhttp.open('GET', url, true);
    xhttp.setRequestHeader('http_x_requested_with', 'true');
    xhttp.send();
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

window.onload = function () {

    /*Modals*/
    let modalCloseButtons = document.querySelectorAll('.modal > .container > .close-button');
    let modalCloseButton;
    for (let i = 0; i < modalCloseButtons.length; i++) {
        modalCloseButton = modalCloseButtons[i];
        modalCloseButton.addEventListener('click', function () {
            modalCloseButton.parentElement.parentElement.classList.remove('show');
        });
    }
    let modal;
    window.addEventListener('click', function windowOnClick(event) {
        let modals = document.querySelectorAll('.modal');
        for (let i = 0; i < modals.length; i++) {
            modal = modals[i];
            if (event.target === modal) {
                modal.classList.remove('show');
            }
        }
    });


    /*Navigation*/
    let navItems = document.querySelectorAll('nav a');
    let navItem;
    for (let i = 0; i < navItems.length; i++) {
        navItem = navItems[i];
        if (window.location.pathname === navItem.getAttribute('href')) {
            navItem.classList.add('active');
        }
    }

    /*pageload event firing*/
    send('pageload');

}