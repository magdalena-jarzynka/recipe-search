<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
    <meta charset="UTF-8"/>
</head>
<body>
<#list recipes as recipe>
    <a href="${recipe}">${recipe}</a>
</#list>
</body>
</html>