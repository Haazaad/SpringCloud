angular.module('cloud').controller('productsController', function ($rootScope, $scope, $http, $location) {
    const contextPath = 'http://localhost:8888/front_service/products/v1';

    $scope.getProducts = function () {
        $http.get(contextPath)
            .then(function successCallback (response) {
                $scope.products = response.data
            }, function failureCallback (response) {
                console.log(response)
            })
    }

    $scope.getProducts();
});