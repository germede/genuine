function send(eventId) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status >= 200 || this.status < 300)) {
            handle(this.responseText);
        }
    };
    let url = window.location.href + '?eventId=' + eventId;
    xhttp.open('GET', url , true);
    xhttp.setRequestHeader('http_x_requested_with', 'true');
    xhttp.send();
}

let COMMANDS_DELIMITER = '&&&';
let COMMAND_DELIMITER = '@@@';
let PARAMETER_DELIMITER = '###';
function handle(response) {
    let commands = response.split(COMMANDS_DELIMITER)
    for (i = 0; i < commands.length; i++) {
        let command = commands[i].split(COMMAND_DELIMITER);
        execute(command[0], command[1].split(PARAMETER_DELIMITER))
    }
}

function getElementByXpath(xpath) {
  console.log(xpath);
  return document.evaluate(decodeURI(xpath), document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
}

function execute(command, arguments) {
    switch(command) {
        case 'CHANGE_INNER': getElementByXpath(arguments[0]).innerHTML = arguments[1]; break;
        case 'APPEND_CHILD': getElementByXpath(arguments[0]).innerHTML += arguments[1]; break;
    }
}

