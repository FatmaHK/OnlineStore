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
            location.href = "MainHome.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };

      $scope.signin = function() {
        var data={username:$scope.username, password:$scope.password};
        $http({
            method: 'POST',
            url: 'http://localhost:8080/onlinemarket/signin',
            params: data
        }).then(function successCallback(response) {
            location.href = "MainHome.html";
            }, function errorCallback(response) {
                alert("Invalid username or password.");
        });
      };
});