var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.signup = function() {
        var data={namenewStore: $scope.namenewStore , OwnernewStore:$scope.OwnernewStore,
		,type:"StoreOwner"};
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/addproduct',
            params: data
          }).then(function successCallback(response) {
            location.href = "StoreOwner.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };
}