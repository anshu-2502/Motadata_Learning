var wsURI;

if(document.location.protocol =="https:"){

    wsURI = "wss://" + window.location.host + "/chat";


}
else{

    wsURI = "ws://" + window.location.host + "/chat";

}


var websocket = new WebSocket(wsURI);

console.log(document.location.protocol);



websocket.onmessage = function(evnt) {

    onMessage(evnt);
};

websocket.onopen = function()  {



    onOpen();
};

function onOpen() {

    console.log("Opened connection: " + wsURI);
}

function onClose() {


    console.log("Closed connection: " );

    onOpen()
}

function onMessage(event) {

    console.log(event);

    display(event.data);
}

function display(dataString) {

    var data = JSON.parse(dataString);

    var contentMessage = "<p>User " + data.userName + " says: " + data.content + "</p>";

    document.getElementById("output").innerHTML += contentMessage + "</br>";
}

function send() {
    var message = document.getElementById("message_input").value;

    var username = document.getElementById("username_input").value;

    var json = {

        "content": message,
        "userName": username
    };

    console.log("Sending " + message);

    websocket.send(JSON.stringify(json));
}
