var  pickup= localStorage.getItem("pickup"); 
var destination = localStorage.getItem("destination"); 
var lat= parseFloat(localStorage.getItem("lat")); 
var lng=  parseFloat(localStorage.getItem("lng")); 


function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer; 
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 7,
        });

		var geocoder = new google.maps.Geocoder();		
		geocoder.geocode( { 'address': destination}, function(results, status) {
		
		  if (status == google.maps.GeocoderStatus.OK) {
		    var latitude = results[0].geometry.location.lat();
		    var longitude = results[0].geometry.location.lng();
			document.getElementById('Dlat').value = latitude;
		    document.getElementById('Dlng').value = longitude;
		  } 
		}); 

        directionsDisplay.setMap(map);
		PickupToDestination(directionsService, directionsDisplay);
				
         
      }

function initMap2() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 7,
        });

		var geocoder = new google.maps.Geocoder();		
		geocoder.geocode( { 'address': destination}, function(results, status) {
		
		  if (status == google.maps.GeocoderStatus.OK) {
		    var latitude = results[0].geometry.location.lat();
		    var longitude = results[0].geometry.location.lng();
			document.getElementById('Dlat').value = latitude;
		    document.getElementById('Dlng').value = longitude;
		  } 
		}); 
		
        directionsDisplay.setMap(map);
		CurrentToPickup(directionsService, directionsDisplay);
				
         
  	}
      
function PickupToDestination(directionsService, directionsDisplay) {
        directionsService.route({
          origin: pickup,
          destination:destination,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }

	  
function CurrentToPickup(directionsService, directionsDisplay) {
        directionsService.route({
          origin: {lat: lat , lng: lng},
          destination: pickup,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }