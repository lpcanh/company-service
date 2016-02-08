(function () {
    'use strict';
    angular
        .module('myApp.company')
        .factory('companyService', companyService);

    companyService.$inject = ['$http', '$log'];

    function companyService ($http, $log) {
        var URL = '/company';
        return {
            getAll: getAll,
            create: create,
            get: get,
            update: update,
            remove: remove
        };

        ////////////////
        function getAll(){
            return $http.get(URL);
        }

        function create (form) {
            return $http.post(URL, form);
        }

        function get(id){
            return $http.get(URL + '/' + id);
        }

        function update(id, form){
            return $http.post(URL + '/' + id, form);
        }

        function remove(id){
            return $http.delete(URL + '/' + id);
        }
    }
})();

