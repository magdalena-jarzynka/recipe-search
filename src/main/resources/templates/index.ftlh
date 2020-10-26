<!DOCTYPE html>
<html xmlns:display="http://www.w3.org/1999/xhtml">
<head>
    <title>Recipe Search</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/easy-loading.min.css">
</head>
<body>

<div class="container">

    <div class="input-group mb-3">
    <select class="form-control" multiple="multiple">
        <option>cukier puder</option>
        <option>cukier</option>
        <option>czekolada biała</option>
        <option>czekolada deserowa</option>
        <option>czekolada gorzka</option>
        <option>czekolada mleczna</option>
        <option>ekstrakt z wanilii</option>
        <option>jajka</option>
        <option>jogurt (naturalny lub grecki)</option>
        <option>kakao</option>
        <option>masło</option>
        <option>mleko</option>
        <option>mąka pszenna</option>
        <option>nutella</option>
        <option>proszek do pieczenia</option>
        <option>serek mascarpone</option>
        <option>skrobia ziemniaczana</option>
        <option>śmietana kremówka 30% lub 36%</option>
        <option>twaróg</option>
    </select>
        <div class="input-group-append">
        <button class="btn btn-primary" type="submit" onclick="search()">Szukaj</button>
        </div>
    </div>

    <div class="search-result-display">
    </div>

</div>


<script src="https://code.jquery.com/jquery-3.5.1.min.js"
        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
<script type="text/javascript" src="js/easy-loading.min.js"></script>
<script type="text/javascript" src="js/multi-select-box.js"></script>
<script type="text/javascript" src="js/search-script.js"></script>

</body>
</html>