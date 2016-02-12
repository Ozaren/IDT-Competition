// SERVICES
packageDeliveryApp.service('packageService', ['$resource', '$routeParams', '$interval', function($resource, $routeParams, $interval) {
    
	var self = this;
	
	//add new timestamp to avoid IE cache       
	this.callAtInterval = function(mode) {
        var weatherAPI = $resource("/getAllPackageData?rnd="+new Date().getTime());                       
		var weatherResult = weatherAPI.query(function(){
        	//console.log($scope.weatherResult);
       });
		
		return weatherResult;
    }
    
	 this.mapProp = {
	         center:new google.maps.LatLng(39.263, -76.579),
	         zoom:9,
	         mapTypeId:google.maps.MapTypeId.ROADMAP
	       }; 		    	       
	 
	 this.getNewMap = function(){
		return new google.maps.Map(document.getElementById('map'), self.mapProp);	
		 
	 }
	 this.getNewBounds = function(){
		return new google.maps.LatLngBounds();
	 }
	 
	 this.getPoly = function(map){
		 var poly = new google.maps.Polyline({
			    strokeColor: '#000000',
			    strokeOpacity: 1.0,
			    strokeWeight: 3
			  });
		 poly.setMap(map);
		 
		 return poly;		 
	 }
	  
	this.getGPSData = function(eventUuid, map, latlngbounds, poly, destinationLat, destinationLon, status){
		var gpsDataAPI = $resource("/getGPSData/:uuid?rnd="+new Date().getTime(), {uuid: eventUuid});  
		gpsDataAPI.query(function(profiles){
		  	  
		   	  var gpsDataResult = profiles;		   	  
		   	  var startLatLng = new google.maps.LatLng(gpsDataResult[0].lat, gpsDataResult[0].lon);			
		   	  var endLatLng = new google.maps.LatLng(destinationLat, destinationLon);
		   	  
		   	  latlngbounds.extend(startLatLng);
		   	  latlngbounds.extend(endLatLng);
		   	  
		   	  //set map bounds
		   	  map.fitBounds(latlngbounds);

		   	  //add start end marker
		   	  var startmarker = new google.maps.Marker({
		   		  position: startLatLng,
		   		  //title: '#' + path.getLength(),
		   		  icon: 'http://maps.google.com/mapfiles/ms/icons/blue-dot.png',
		   		  map: map
		   	  });
		   	  var endmarker = new google.maps.Marker({
		   		  position: endLatLng,
		   		  //title: '#' + path.getLength(),
		   		  icon: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
		   		  map: map
		   	  });   
		   		  
		   	  //add poly line
		   	  angular.forEach(gpsDataResult,function(value,index){
		   		  addLatLng(value.lat, value.lon, poly);
		   	  });	
		   	  

		   	  self.getLatestGPSData(eventUuid, map, latlngbounds, poly);
						
		});
	}
	
	this.getLatestGPSData = function(eventUuid, map, latlngbounds, poly, stop){
		var gpsLatestDataAPI = $resource("/getLatestGPSData/:uuid?rnd="+new Date().getTime(), {uuid: eventUuid});  
		gpsLatestDataAPI.get(function(profiles){		  	 
			var gpsDataResult = profiles;	
			 var latLng = new google.maps.LatLng(gpsDataResult.lat, gpsDataResult.lon);
		     latlngbounds.extend(latLng);
		     map.fitBounds(latlngbounds);
		     
			addLatLng(gpsDataResult.lat, gpsDataResult.lon, poly);
			
			
			if (!angular.isDefined(stop) )
				stop=$interval( function(){self.getLatestGPSData(eventUuid, map, latlngbounds, poly, stop); }, 5000);
			
			if(gpsDataResult.status=='Delivered') {
		   		$interval.cancel(stop);
		   		console.log("stop");
		   	}
		});		
	}
	//test end
	
	 // Handles click events on a map, and adds a new point to the Polyline.
    function addLatLng(lat, lon, poly) {  	
      var path = poly.getPath();

      // Because path is an MVCArray, we can simply append a new coordinate
      // and it will automatically appear.
      latLng = new google.maps.LatLng(lat, lon);
      path.push(latLng);
      
      // Add a new marker at the new plotted point on the polyline.
     // var marker = new google.maps.Marker({
     //   position: latLng,
     //   title: '#' + path.getLength(),
     //   map: map
     // });
    }
    
   
}]);

packageDeliveryApp.service('modeService', ['$interval', function($interval) {
	this.mode;   
    this.uuidList = [];
    this.stopDeliverDetailInterval;
    
    this.updateMode = function(mode){
    	this.mode = mode;
    }
    
    this.updateDeliverDetailInterval = function(stop){
    	this.stopDeliverDetailInterval = stop;
    }
    
    this.stopDDInterval = function(){
    	$interval.cancel(this.stopDeliverDetailInterval);
    	console.log("DDInterval stop");
    }
}]);