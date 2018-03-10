var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.addStore = function() {
        var data={name: $scope.name , type:$scope.type, ownerName:$scope.ownerName ,
            location:$scope.location};
            $http({
                method: 'GET',
                url: 'http://localhost:8080/onlinemarket/addstore/request',
                params: data
            }).then(function successCallback(response) {
                alert("done.");
                }, function errorCallback(response) {
                    alert("Invalid username or password.");
            });
    };
});