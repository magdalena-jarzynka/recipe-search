<!DOCTYPE html>
<html xmlns:display="http://www.w3.org/1999/xhtml">
<head>
    <title>Recipe Search</title>
    <meta charset="UTF-8"/>

<#--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"-->
<#--          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">-->

    <link rel="stylesheet" href="css/seotime/font-awesome.min.css">
    <link rel="stylesheet" href="css/seotime/bootstrap.min.css">
    <link rel="stylesheet" href="css/seotime/animate.css">
    <link rel="stylesheet" href="css/seotime/carousel.css">
    <link rel="stylesheet" href="css/seotime/style.css">

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/easy-loading.min.css">

    <link rel="stylesheet" href="css/custom.css">

</head>
<body>

<div id="wrapper">

    <div class="topbar">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6 hidden-xs">
                    <nav class="topbar-menu">
                        <ul class="list-inline">
                            <li>Obserwuj mnie: </li>
                            <li><a href="https://www.linkedin.com/in/magdalena-jarzynka/"><img src="images/LI-In-Bug.png" class="linkedin-img"></a></li>
                            <li><a href="https://github.com/magdalena-jarzynka"><img src="images/GitHub-Mark-32px.png"></a></li>
                        </ul><!-- end list -->
                    </nav><!-- end menu -->
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end topbar -->


    <section class="section transheader homepage parallax background-img" data-stellar-background-ratio="0.5">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1 col-sm-12">
                    <div class="text-center">
                    <h2>Wyszukaj przepisy z mojewypieki.com</h2>
                    <p class="lead">Pyszne wypieki ze składników dostępnych w Twojej kuchni</p>
                    </div>
                        <div class="input-group mb-3 calculateform">
                            <select class="form-control" multiple="multiple">
                                <#list allIngredients as ingredient>
                                    <option>${ingredient}</option>
                                </#list>
                            </select>
                            <div class="input-group-append">
                                <button class="btn btn-primary search-button" type="submit" onclick="search()">Szukaj</button>
                            </div>
                        </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <div class="search-result-display">
    </div>

</div>



<#--<script src="https://code.jquery.com/jquery-3.5.1.min.js"-->
<#--        integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="-->
<#--        crossorigin="anonymous"></script>-->
<#--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"-->
<#--        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"-->
<#--        crossorigin="anonymous"></script>-->
<#--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"-->
<#--        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"-->
<#--        crossorigin="anonymous"></script>-->

<script type="text/javascript" src="js/seotime/jquery.min.js"></script>
<script type="text/javascript" src="js/seotime/bootstrap.min.js"></script>
<script type="text/javascript" src="js/seotime/parallax.js"></script>
<script type="text/javascript" src="js/seotime/animate.js"></script>
<script type="text/javascript" src="js/seotime/owl.carousel.js"></script>
<script type="text/javascript" src="js/seotime/custom.js"></script>

<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-beta.1/dist/js/select2.min.js"></script>
<script type="text/javascript" src="js/easy-loading.min.js"></script>
<script type="text/javascript" src="js/multi-select-box.js"></script>
<script type="text/javascript" src="js/search-script.js"></script>

</body>
</html>