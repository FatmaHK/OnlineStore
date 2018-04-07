var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.signup = function() {
        var data={namenewStore: $scope.namenewStore ,OwnernewStore:$scope.OwnernewStore
		,type:"Admin"};
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/addstore/request',
            params: data
          }).then(function successCallback(response) {
            location.href = "Administrator.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };
}