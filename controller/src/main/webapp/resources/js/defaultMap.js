var infoBox = document.getElementById('info');

var vectorSource = new ol.source.Vector({
                url: 'https://openlayers.org/en/v4.1.0/examples/data/geojson/countries.geojson',
                format: new ol.format.GeoJSON()
  });


var map = new ol.Map({

    layers: [
      new ol.layer.Tile({
        source: new ol.source.OSM()
      }),
      new ol.layer.Vector({
        source: vectorSource
      })
    ],
    target: 'map',
    view: new ol.View({
      center: [0, 0],
      zoom: 2,
      maxResolution:60000
    })
});

  // a normal select interaction to handle click
  var select = new ol.interaction.Select();
  map.addInteraction(select);

  var selectedFeatures = select.getFeatures();

  var selectPointerMove = new ol.interaction.Select({
          condition: ol.events.condition.pointerMove
    });
    map.addInteraction(selectPointerMove);

  // a DragBox interaction used to select features by drawing boxes
  var dragBox = new ol.interaction.DragBox({
    condition: ol.events.condition.platformModifierKeyOnly
    });

    map.addInteraction(dragBox);

    dragBox.on('boxend', function() {
        // features that intersect the box are added to the collection of
        // selected features, and their names are displayed in the "info"
        // div
        var info = [];
        var extent = dragBox.getGeometry().getExtent();
        vectorSource.forEachFeatureIntersectingExtent(extent, function(feature) {
          selectedFeatures.push(feature);
          info.push(feature.get('name'));
        });

        if (info.length > 0) {
          infoBox.innerHTML = info.join(', ');
        }
    });

    // clear selection when drawing a new box and when clicking on the map
    dragBox.on('boxstart', function() {
        selectedFeatures.clear();
        infoBox.innerHTML = '&nbsp;';
        });

    map.on('click', function(e) {
        selectedFeatures.clear();
        infoBox.innerHTML = '&nbsp;';
        var pixel = map.getPixelFromCoordinate(e.coordinate);
        map.forEachFeatureAtPixel(pixel, function(feature) {
                infoBox.innerHTML = feature.get('name');
        });
});