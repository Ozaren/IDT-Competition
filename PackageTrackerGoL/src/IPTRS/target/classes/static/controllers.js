// CONTROLLERS
packageDeliveryApp.controller('mainController', ['$scope', 'modeService', function($scope, modeService) {
	 $scope.clearUserMode = function(){
	    	modeService.updateMode(null);
	    	modeService.stopDDInterval();
	 }
}]);

packageDeliveryApp.controller('homeController', ['$scope', 'modeService', function($scope, modeService) {   
    $scope.uuidList = modeService.uuidList;
    
    $scope.$watch('uuidList', function() {
       modeService.uuidList = $scope.uuidList; 
       //trim each value from the uuidList, so whitespace won't affect the filter       
       for (var i = 0; i < modeService.uuidList.length; i++) {
    	   modeService.uuidList[i] = modeService.uuidList[i].trim();
    	 }
    });
    
    $scope.updateMode = function(mode){
    	modeService.updateMode(mode);
    }
    
    $scope.getUserMode = function(){
    	return modeService.mode;
    }
    
}]);

packageDeliveryApp.controller('deliveryDetailController', ['$scope', '$resource', '$routeParams', '$interval', 'packageService', 'modeService', function($scope, $resource, $routeParams, $interval, packageService, modeService) {	
	//get package summary data first
    $scope.weatherResult = packageService.callAtInterval(modeService.mode);       
    //get package summary data at 5 sec interval
    var stopDDInterval= $interval( function(){ $scope.weatherResult= packageService.callAtInterval(modeService.mode); }, 5000);    
    modeService.updateDeliverDetailInterval(stopDDInterval);
    
    //set up filter for ng-repeat    
    $scope.uuidList = modeService.uuidList;
    $scope.filterArray = function(hash) {
    	if(modeService.mode=='userView')
    		return ($scope.uuidList.indexOf(hash.uuid) !== -1);
    	else
    		return true;
    };
    
    $scope.stopDDInterval = function(){
    	modeService.stopDDInterval();
    }
    
    //google map
    var poly;
    var map;
    $scope.selectedUuid;
    
    $scope.initMap = function(eventUuid, destinationLat, destinationLon, status) {    
      $scope.selectedUuid = eventUuid;
      var map = packageService.getNewMap();
      var bounds = packageService.getNewBounds();
      var poly = packageService.getPoly(map);
      packageService.getGPSData(eventUuid, map, bounds, poly, destinationLat, destinationLon, status);
     
      //$interval( function(){packageService.getLatestGPSData(eventUuid, map, bounds, poly); }, 5000);
    }
   
}]);