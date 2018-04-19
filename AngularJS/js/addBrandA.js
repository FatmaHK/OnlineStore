var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
     $scope.signup = function() {
        var data={brandName: $scope.brandName , brandCategory:$scope.brandCategory,type:"Admin"};
        $http({
            method: 'GET',
            url: 'localhost:8080/onlinemarket/addbrand',
            params: data
          }).then(function successCallback(response) {
            location.href = "Administrator.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };
}