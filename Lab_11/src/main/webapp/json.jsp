<!DOCTYPE html>
<html>
<head>
    <title>Json</title>
</head>
<body>

<b> AJAX Example (JSON) </b>
<form name="FXML" action="#" method="POST">
    <input name="n" type="text" value="0" size="2" maxlength="2" />
    <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
           onclick="OnClick_JSON(this.form.n.value,
                     document.getElementById('json'))" />
    &emsp; <span id="json" class="h2">.....</span>
</form>

</body>
</html>
<script type="text/javascript" src="js/json.js"></script>

