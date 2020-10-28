<section class="section overfree">
    <div class="icon-center"><i class="fa fa-arrow-down"></i></div>
    <div class="container">
        <div class="section-title text-center">
            <h3>Wyniki wyszukiwania</h3>
            <hr>
        </div><!-- end section-title -->
        <div class="row service-list text-center">
            <#list recipes as recipe>
                <div class="col-lg-4 d-flex align-items-stretch">
                    <div class="service-wrapper wow fadeIn">
                        <div class="service-details">
                            <a href="${recipe.url}">
                                <img src="${recipe.imageUrl}" class="recipe-photo" alt="Photo">
                                <h4 class="text-on-image">${recipe.title}</h4>
                            </a>
                        </div>
                    </div><!-- end service-wrapper -->
                </div><!-- end col -->
            </#list>
        </div><!-- end row -->
    </div><!-- end container -->
</section><!-- end section -->