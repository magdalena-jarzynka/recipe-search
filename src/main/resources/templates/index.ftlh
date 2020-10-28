<!DOCTYPE html>
<html>
<head>
    <title>Recipe Search</title>
    <meta charset="UTF-8"/>

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
                            <li>Obserwuj mnie:</li>
                            <li><a href="https://www.linkedin.com/in/magdalena-jarzynka/"><img
                                            src="images/LI-In-Bug.png" class="linkedin-img"></a></li>
                            <li><a href="https://github.com/magdalena-jarzynka"><img src="images/GitHub-Mark-32px.png"></a>
                            </li>
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
                            <button class="btn btn-primary search-button" type="submit" onclick="search()">Szukaj
                            </button>
                        </div>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <div class="search-result-display">
    </div>

</div>

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