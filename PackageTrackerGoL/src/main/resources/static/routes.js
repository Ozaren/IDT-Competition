// ROUTES
packageDeliveryApp.config(function ($routeProvider) {
   
    $routeProvider
    
    .when('/', {
        templateUrl: 'home.htm',
        controller: 'homeController'
    })
    
    .when('/deliveryDetail', {
        templateUrl: 'pages/deliveryDetail.htm',
        controller: 'deliveryDetailController'
    })
    
    .when('/deliveryDetail/:days', {
        templateUrl: 'pages/deliveryDetail.htm',
        controller: 'deliveryDetailController'
    })
    
});