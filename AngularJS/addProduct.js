var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.addProduct = function() {
        var data={name: $scope.name , price:$scope.price, type:$scope.type ,
            brand:$scope.brand, quantity:$scope.quantity};
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/addproduct',
            params: data
        }).then(function successCallback(response) {
            alert("done.");
        }, function errorCallback(response) {
            alert("try again");
        });
    };
});