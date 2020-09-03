<div class="row">
    <#list recipes as recipe>
        <div class="col-lg-4 d-flex align-items-stretch">
            <div class="card text-center">
                <img src="${recipe.imageUrl}" class="card-img-top" alt="Photo">
                <div class="card-body">
                    <h5 class="card-title"><a href="${recipe.url}">${recipe.title}</a></h5>
                </div>
            </div>
        </div>
    </#list>
</div>