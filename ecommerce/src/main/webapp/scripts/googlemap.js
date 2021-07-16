//define initMap function

function initMap(){
	var urlfront = "https://maps.googleapis.com/maps/api/geocode/json?address=+";
	var urlback = "+CA$key=";
	var urlkey = "";//Please input Google Map API here.
	var lat = 0;
	var lng =0;
	//get addresses from database through googlemap_process.php
	$.get("googlemap_process.php",function(addressphp){

			// get coords from google map api
			// call back by a json value
			$.ajax({
				url:urlfront+addressphp+urlback+urlkey,
				type:"get",
				async:true,
				dataType:"json",
				success:function(data){
					lat = parseFloat(data.results[0].geometry.location.lat);
					lng = parseFloat(data.results[0].geometry.location.lng);

					var uluru = {lat,lng};
					var map = new google.maps.Map(document.getElementById('map'),{
						center:uluru,
						zoom:17
					});

					var marker = new google.maps.Marker({
						position:uluru,
						map:map,
					})
				}
				// error:function(error){
				// 	alert ('Please refresh it.');
				// }
			});
					

			
		});

}

// $(document).ready(function(){
// 	initMap();

// })
