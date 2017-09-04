$(document).ready(function(){

$("#accordion").accordion({
             active: false,
             collapsible: true,
             heightStyle: "content"
});


});

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
            dataType: 'json',
            success: function(data){
               window.alert(data.capital);
               updateCountryInformationView(data);
            },
            error: function(){
                window.alert("Failed");
               }
        });
}

function updateCountryInformationView(data){

    var infoResult = "<div class=\"value name\">" + data.name + "</div>"
    + "<div class=\"value capital\">" + data.capital + "</div>"
    + "<div class=\"value currencies\">" + data.currencies + "</div>"
    + "<div class=\"value languages\">" + data.languages + "</div>"
    + "<a class=\"value flag\" href=#><img src=" + data.flag + "></a>";
    $(".countryInformation").html(infoResult);

}
