function findByName(searchKey) {

    if($('#title' + searchKey).attr('aria-expanded') == "true"){

        $('#collapse'+id).empty();
    }else{

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/geomonitor/' + searchKey,
        dataType: 'html',
        success: function(data){
            updateView(searchKey, data);
        }
    });

    }
}

function updateView(id, html){

    $('#collapse' + id).append(html);
}