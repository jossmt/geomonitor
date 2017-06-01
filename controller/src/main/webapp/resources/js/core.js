function findByName(searchKey) {

    if($('#title' + searchKey).attr('aria-expanded') == "true"){

        $('#collapse'+searchKey).html('');

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

function getCountryData(name){

    $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/geomonitor/map/' + name,
            dataType: 'html',
            success: function(data){
                updateView(searchKey, data);
            }
        });
}

function updateCountryInfo(countryData){
    $('#countryInfo').append(countryData)
}