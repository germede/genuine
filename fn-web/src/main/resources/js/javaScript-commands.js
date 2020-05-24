function send(eventId) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && (this.status >= 200 || this.status < 300)) {
            handle(this.responseText);
        }
    };
    xhttp.open('GET', window.location.href + '?eventId=' + eventId , true);
    xhttp.setRequestHeader('http_x_requested_with', 'true');
    xhttp.send();
};

let COMMANDS_DELIMITER = '&&&';
let COMMAND_DELIMITER = '@@@';
let PARAMETER_DELIMITER = '###';
function handle(response) {
    let commands = response.split(COMMANDS_DELIMITER)
    for (i = 0; i < commands.length; i++) {
        let command = commands[i].split(COMMAND_DELIMITER);
        call(command[0], command[1].split(PARAMETER_DELIMITER))
    }
}

function call(command, arguments) {
    switch(command) {
        case 'CHANGE_INNER': document.getElementById(arguments[0]).innerHTML = arguments[1]; break;
        case 'APPEND_CHILD': document.getElementById(arguments[0]).innerHTML += arguments[1]; break;
    }
}

