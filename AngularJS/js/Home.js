var app = angular.module('myApp', []);
app.controller('mycontroller', function ($scope, $http) {
    'use strict';
    $scope.submitForData = function () {
        alert("Hello");
    };
    $scope.myFunc = function () {
        var data = {name: $scope.$name, username: $scope.username, email: $scope.email, password: $scope.password, type: "visitor"};
        $http({
            method: 'GET', url: ' ',
            params: data
        }).then(function successCallback(response) {
            location.href = "Register.html";
        }, function errorCallback(response) {
            alert("try again");
        });
    };
});



var app = angular.module('myApp', []);
app.controller('mycontroller', function ($sscope, $http) {
    'use strict';
    $sscope.LogInForm = function () {
        alert("Hello")
    };
    $sscope.myFunc = function () {
        var data = {name: $sscope.$name, $scope.password, type: "visitor"};
        $http({
            method: 'GET', url:'',
            params: data
        }).then(function successCallback(response) {
            location.href = "LogIn.html";
        }, function errorCallback(response) {
            alert("try again")
        });
    };
});




angular.module('addProduct', []).controller('addNewProduct', ['$ProductController', function ($ProductController) {
    'use strict';
    var url = "/onlinemarket/addproduct";

}]);


angular.module('addStore', []).controller('addNewStore', ['$StoreController', function ($StoreController) {
    'use strict';
    var url = "/onlinemarket/addstore/request";
    $StoreController.name;
    $StoreController.type;
    $StoreController.OwnerName;
    $StoreController.Location;
    $StoreController.addStore = function () {
    };
}]);