<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<head>

    <link rel="stylesheet" href="https://openlayers.org/en/v4.1.0/css/ol.css" type="text/css">
    <!-- The line below is only needed for old environments like Internet Explorer and Android 4.x -->
    <script src="https://cdn.polyfill.io/v2/polyfill.min.js?features=requestAnimationFrame,Element.prototype.classList,URL"></script>
    <script src="https://openlayers.org/en/v4.1.0/build/ol.js"></script>

    <style>
      .ol-dragbox {
        background-color: rgba(255,255,255,0.4);
        border-color: rgba(100,150,0,1);
      }
    </style>

</head>

<tiles:insertDefinition name="defaultTemplate">

    <!-- core js -->
    <script src="<c:url value="/resources/js/core.js"/>"></script>

    <!-- core jquery ui -->
    <script src="<c:url value="/resources/js/jquery-ui.min.js"/>"></script>

    <tiles:putAttribute name="body">

    <div id="mapContainer" style="text-align: center">
        <div id="map" class="map"></div>
        <div id="info">No countries selected</div>
    </div>

    <div class="countryInformation" style="text-align: center"></div>

    <script src="<c:url value="/resources/js/core.js"/>"></script>
    <script src="<c:url value="/resources/js/defaultMap.js"/>"></script>

    </tiles:putAttribute>
</tiles:insertDefinition>