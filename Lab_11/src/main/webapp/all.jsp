<!DOCTYPE html>
<html>
<head>
    <title>All</title>
</head>
<body>

<label for="async">
    async
</label>

<input type="checkbox" value="async" id="async">

<form id="headers" name="FHeader" action="#" method="POST">
    <label> Headers:
        <label>x:
            <input id="x" type="text" value="0" size="5" maxlength="5" />
        </label>
        <label>y:
            <input id="y" type="text" value="0" size="5" maxlength="5" />
        </label>
        <label>z:
            <input id="z" id="z" type="text" value="0" />
        </label>
    </label>
    <br>
    <label> JSON:
        <label>n:
            <input id="n" type="text" value="0" size="2" maxlength="2" />
        </label>
    </label>
    <span id="json" class="h2">.....</span>

    <br>
    <label> XML:
        <label>n:
            <input id="m" type="text" value="0" size="2" maxlength="2" />
        </label>
    </label>
    <span id="xml" class="h2">.....</span>
    <br>
    <input name="Execute" value="Execute" type="button" size="10" maxlength="10" onclick="execute()"/>

</form>

</body>
</html>

<script type="text/javascript" src="js/allreq.js"></script>

<script>
    let execute = () => {
        allRequests(
            document.getElementById("x"),
            document.getElementById("y"),
            document.getElementById("z"),
            document.getElementById("n"),
            document.getElementById("m")
        )
    }
</script>

