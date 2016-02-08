(function () {
    'use strict';
    angular
        .module('myApp.company')
        .factory('BeneficialOwnerService', BeneficialOwnerService);

    BeneficialOwnerService.$inject = ['$log', '$http'];

    function BeneficialOwnerService ($log, $http) {
        return function(id){
            if(!id)throw 'Invalid Id';
            var URL = '/company/' + id + '/beneficial-owner';

            return {
                getAll: getAll,
                create: create,
                get: get,
                update: update,
                remove: remove
            }

            function getAll () {
                return $http.get(URL);
            }

            function create(form){
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
        };
    }
})();

