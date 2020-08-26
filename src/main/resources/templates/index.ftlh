<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
    <meta charset="UTF-8"/>
</head>
<body>
<#list recipes as recipe>
    <p><a href="${recipe}">${recipe}</a></p>
</#list>
</body>
</html>