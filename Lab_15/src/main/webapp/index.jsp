<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script type="text/javascript">
        let ws = null;

        function connect() {
            ws = new WebSocket("ws://localhost:8080/Lab_15/websocket");

            ws.onmessage = function (event) {
                console.log(event.data)
                document.getElementById('out-div').innerHTML = event.data;
            };
        }

        function disconnect(){
            console.log('close')
            ws.close();
        }
    </script>
</head>
<body>
<button onclick="connect()">START</button>
<button onclick="disconnect();">STOP</button>
<div id="out-div"></div>
</body>
</html>