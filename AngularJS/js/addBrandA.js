var app = angular.module('myApp2', []);
app.controller('myCtrl2', function($scope, $http) {
     $scope.addbrand = function () {
        var data = { brandname: $scope.brandname, brandcategory: $scope.brandcategory};
        $http({
            method: 'GET',
            url: 'http://localhost:8080/onlinemarket/addbrand',
            params: data
          }).then(function successCallback(response) {
            location.href = "Administrator.html";
            }, function errorCallback(response) {
                alert("try again");
            });
      };
});