var app = angular.module('crudApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: 'http://localhost:8080/SpringBootCRUDApp',
    USER_SERVICE_API : 'http://localhost:8080/employees'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'EmployeeRestController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all employees');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);