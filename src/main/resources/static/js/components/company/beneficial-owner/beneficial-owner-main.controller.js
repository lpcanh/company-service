(function () {
    'use strict';
    angular
        .module('myApp.company.beneficialOwner')
        .controller('beneficialMainController', beneficialMainController);

    beneficialMainController.$inject = ['$stateParams', '$log', 'BeneficialOwnerService', 'id', '$scope', '$window'];

    function beneficialMainController ($stateParams, $log, BeneficialOwnerService, id, $scope, $window) {
        var vm = this;
        $log.info('Beneficial Main');
        $log.info($stateParams);
        var beneficialService = new BeneficialOwnerService(id);
        vm.company = $stateParams.company;
        vm.remove = remove;

        getAll();

        function remove (beneficial) {
            if ($window.confirm('DELETE Beneficial ' + beneficial.name + ' of company' + vm.company.name)) {
                beneficialService.remove(beneficial.id).then(function (resp) {
                    getAll();
                });
            }
        }

        function getAll () {
            beneficialService.getAll().then(function (resp) {
                vm.beneficials = resp.data;
            });
        }

        $scope.$on('update', function () {
            $log.info('Update Event');
            getAll();
        });
    }
})();