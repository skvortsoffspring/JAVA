<!DOCTYPE html>
<html>
<head>
    <title>XML</title>
</head>
<body>

<b> AJAX Example (XML) </b>
<form name="FXML" action="#" method="POST">
    <input name="n" type="text" value="0" size="2" maxlength="2" />
    <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
           onclick="OnClick_XML(this.form.n.value,
                     document.getElementById('xml'))" />
    &emsp; <span id="xml" class="h2">.....</span>
</form>


</body>
</html>
<script type="text/javascript" src="js/xml.js"></script>

