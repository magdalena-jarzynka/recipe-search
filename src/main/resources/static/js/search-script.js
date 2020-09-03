function search() {
    $.ajax({
        traditional: true,
        url: '/',
        type: 'GET',
        data: {
            'ingredient': $(".form-control").val()
        },
        success: function(data) {
            $(".search-result-display").empty();
            $(".search-result-display").append(data);
        }
    })
}