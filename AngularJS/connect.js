var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.signup = function() {
        var data={name: $scope.name , username:$scope.username, email:$scope.email ,
            password:$scope.password,type:"Visitor"};
        $http({
            method: 'POST',
            url: 'http://localhost:8080/onlinemarket/signup',
            params: data
          }).then(function successCallback(response) {
            location.href = "Home.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };

      $scope.buyProduct = function() {
        var data={productname:$scope.productname, storename:$scope.storename,requiredAmount:$scope.requiredAmount,type:"Buyer"};
        $http({
            method: 'GET',
            url: 'localhost:8080/onlinemarket/buyproduct',
            params: data
        }).then(function successCallback(response) {
            location.href = "Home.html";
            }, function errorCallback(response) {
                alert("Invalid username or password.");
        });
      };
});