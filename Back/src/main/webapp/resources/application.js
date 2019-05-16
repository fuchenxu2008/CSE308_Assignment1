

var socket = new SockJS('http://localhost:8080/OrchestrationAPI/getdeploymentStatus');
var client = Stomp.over(socket);

client.connect('user', 'password', function(frame) {

  client.subscribe("/data", function(message) {
    var point = [message.body ];
    alert ("point1 "+point);
  });

});