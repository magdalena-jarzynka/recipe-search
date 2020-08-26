<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
    <meta charset="UTF-8"/>
</head>
<body>
<#list recipes as recipe>
    <p><img src="${recipe.imageUrl}" alt="Photo" width="400" height="600"></p>
    <p><a href="${recipe.url}">${recipe.title}</a></p>
</#list>
</body>
</html>