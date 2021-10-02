(function () {
    angular.module('cloud', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'welcome/welcome.html',
                controller: 'welcomeController'
            })
            .when('/products', {
                templateUrl: 'products/products.html',
                controller: 'productsController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
    }
})();

angular.module('cloud').controller('indexController', function () {
    const contextPath = 'http://localhost:8888/front_service';
});