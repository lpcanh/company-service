(function () {
    'use strict';
    angular
        .module('myApp.company')
        .factory('companyService', companyService);

    companyService.$inject = ['$http', '$log'];

    function companyService ($http, $log) {
        var URL = '/company';
        return {
            create: create
        };

        ////////////////

        function create (form) {
            return $http.post(URL, form);
        }
    }
})();

