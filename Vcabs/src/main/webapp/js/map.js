var dist;
var amt;
var myLatLng;
       function initMap() {
		var originAutocomplete = new google.maps.places.Autocomplete(document.getElementById('origin-input'));
			google.maps.event.addListener(originAutocomplete,'place_changed',function(){
		        	var l=originAutocomplete.getPlace().geometry.location;
		        	document.getElementById('lat').value = l.lat();
		        	document.getElementById('lng').value = l.lng();
		        });
		var destinationAutocomplete = new google.maps.places.Autocomplete(document.getElementById('destination-input'));		
		infowindow = new google.maps.InfoWindow();
		 if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function(position) {
	
				var myLatLng = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
				//console.log(myLatLng);
				var map = new google.maps.Map(document.getElementById("map"), {
			          mapTypeControl: false,
			          center: myLatLng,
			          zoom: 13
		        });
				var icon = {
				    url: "https://www.pngjoy.com/pngl/101/2112015_marker-circle-map-marker-circle-png-png-download.png", 
				    scaledSize: new google.maps.Size(50, 50), 
				    origin: new google.maps.Point(0,0), 
				    anchor: new google.maps.Point(0, 0) 
				};
				var marker = new google.maps.Marker({
					position: myLatLng,
					 icon: icon
					
				});
				marker.setMap(map);
				new AutocompleteDirectionsHandler(map,originAutocomplete,destinationAutocomplete);
			});
		}
      }

      function AutocompleteDirectionsHandler(map,originAutocomplete,destinationAutocomplete) {
        this.map = map;
        this.originPlaceId = null;
        this.destinationPlaceId = null;
        this.travelMode = 'DRIVING';
       
        this.directionsService = new google.maps.DirectionsService;
        this.directionsDisplay = new google.maps.DirectionsRenderer;
        this.directionsDisplay.setMap(map);

       

        this.setupPlaceChangedListener(originAutocomplete, 'ORIG');
        this.setupPlaceChangedListener(destinationAutocomplete, 'DEST');
      }

     

      AutocompleteDirectionsHandler.prototype.setupPlaceChangedListener = function(autocomplete, mode) {
        var me = this;
        autocomplete.bindTo('bounds', this.map);
        autocomplete.addListener('place_changed', function() {
          var place = autocomplete.getPlace();
          if (!place.place_id) {
            window.alert("Please select an option from the dropdown list.");
            return;
          }

          if (mode === 'ORIG') {
            me.originPlaceId = place.place_id;
          } else {
            me.destinationPlaceId = place.place_id;
          }
          me.route();
        });

      };

      AutocompleteDirectionsHandler.prototype.route = function() {
        if (!this.originPlaceId || !this.destinationPlaceId) {
          return;
        }
        var me = this;

        this.directionsService.route({
          origin: {'placeId': this.originPlaceId},
          destination: {'placeId': this.destinationPlaceId},
          travelMode: this.travelMode
        }, function(response, status) {
          if (status === 'OK') {
            me.directionsDisplay.setDirections(response);
			var center = response.routes[0].overview_path[Math.floor(response.routes[0].overview_path.length / 2)];
		    infowindow.setPosition(center);
			dist=((response.routes[0].legs[0].distance.value)/1000).toFixed(1);			
		    infowindow.setContent(response.routes[0].legs[0].duration.text + "<br>" + response.routes[0].legs[0].distance.text);
		    infowindow.open(me.map);
			
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      };
function gettype(){
	var select=document.getElementById('cartype');
	amt=select.options[select.selectedIndex].value;
	amt=dist*amt;
	document.getElementById('amount').value = (amt.toFixed(2))*100;
	document.getElementById('distance').innerHTML = amt.toFixed(2);
}