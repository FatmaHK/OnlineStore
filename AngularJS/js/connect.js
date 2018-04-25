var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.signup = function() {
        var data={name: $scope.name , username:$scope.username, email:$scope.email ,
            password:$scope.password,type:"Visitor"};
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/signup',
            params: data
          }).then(function (response) {
              alert("LLLLLLLLLL");
            //location.href = "Home.html";
            }, function errorCallback(response) {
                //alert(data.name + data.email + data.username + data.password + data.type);
                //location.href = "SelectYourType.html";
            });
      };


    $scope.signin = function () {
        var data = { username: $scope.username, password: $scope.password };
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/signin',
            params: data
        }).then(function mySuccess(response) {
            location.href = "Home.html";
        }, function myError(response) {
            location.href = "SelectYourType.html";
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