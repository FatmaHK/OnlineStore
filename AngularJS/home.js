angular.module('mainApp',[]);
function main($scope) {
    $scope.render = function(condition) {
        return condition ? "This is rendered when condition == TRUE" : "This is rendered when condition == FALSE";
    };
}
app.controller('ctrl', function($scope, $http) {
    'use strict';
    var url = "/onlinemarket/signup";
    $register.name;
    $register.password;
    $register.email;

    $http({
        method: 'GET',
        url: 'http://localhost:8080/signup'
      }).then(function successCallback(response) {
          alert("done");
        }, function errorCallback(response) {
            alert("try again");
        });
});


var app = angular.module('myApp', []);
app.controller('mycontroller', function ($signIn) {
    'use strict';
    var url = "/onlinemarket/signin/{email}/{password}";
    $signIn.name;
    $signIn.password;
});




angular.module('addProduct', []).controller('addNewProduct', ['$ProductController', function ($ProductController) {
    'use strict';
    var url = "/onlinemarket/addproduct";
    $ProductController.name;
    $ProductController.price;
    $ProductController.type;
    $ProductController.prand;
    $ProductController.quality;
    $ProductController.addproduct = function () {
    };
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