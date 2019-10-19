var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

// function connect() {
//     var socket = new SockJS('/gs-guide-websocket');
//     stompClient = Stomp.over(socket);
//     stompClient.connect({}, function (frame) {
//         setConnected(true);
//         console.log('Connected: ' + frame);
//         stompClient.subscribe('/topic/greetings', function (greeting) {
//             showGreeting(JSON.parse(greeting.body).content);
//         });
//     });
// }
//
// function disconnect() {
//     if (stompClient !== null) {
//         stompClient.disconnect();
//     }
//     setConnected(false);
//     console.log("Disconnected");
// }
// function connect() {
//     var socket = new SockJS('http://localhost:8080/gs-guide-websocket');
//     stompClient = Stomp.over(socket);
//
//     stompClient.connect({}, function(frame) {
//         stompClient.subscribe("/topic/greetings", function(message) {
//             alert("Error " + message.body);
//         });
//     }, function(error) {
//         alert("STOMP error " + error);
//     });
// }

// function connect() {
//     var socket = new SockJS('http://localhost:8080/gs-guide-websocket');
//     stompClient = Stomp.over(socket);
//
//     stompClient.connect({}, function(frame) {
//         stompClient.subscribe("/user/queue/errors", function(message) {
//             alert("Error " + message.body);
//         });
//
//         stompClient.subscribe("/user/queue/reply", function(message) {
//             alert("Message " + message.body);
//         });
//     }, function(error) {
//         alert("STOMP error " + error);
//     });
// }

function connect() {
    // var socket = new SockJS('http://47.254.235.59:8082/gs-guide-websocket');
    var socket = new SockJS('http://localhost:8082/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);

            var test = {name: "abc"};
            $.ajax({
                // url: 'https://www.excerp.tech/api/wms/login',
                url: 'http://47.254.235.59:8082',
                // url: 'http://localhost:8080',
                type: 'post',
                data: JSON.stringify(test),
                contentType: 'application/json',

                success: function (response) {
                    if(response.status===200){
                        console.log("jghjghj");
                    }
                    console.log("outside outside");
                }
            });
        })
    })
}

function disconnect() {
    if (stompClient != null) {
        stompClient.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});