angular.module('cloud').controller('productsController', function ($rootScope, $scope, $http, $location) {
    const contextPath = 'http://localhost:5555/product-service';

    $scope.getProducts = function () {
        $http.get(contextPath + '/api/v1/products')
            .then(function successCallback (response) {
                $scope.products = response.data
            }, function failureCallback (response) {
                console.log(response)
            })
    }

    $scope.getProducts();
});