(function () {
    'use strict';
    angular
        .module('myApp.company')
        .controller('CompanyMainController', CompanyMainController);

    CompanyMainController.$inject = ['$state', '$log', 'companyService', '$window'];

    function CompanyMainController ($state, $log, companyService, $window) {
        var vm = this;
        vm.create = create;
        vm.edit = edit;
        vm.remove = remove;
        vm.reload = loadCompany;

        loadCompany();

        function loadCompany () {
            companyService.getAll().then(function (resp) {
                vm.companies = resp.data;
            });
        }

        function create () {
            $log.info('Create');
            $state.go('company.create');
        }

        function edit (id) {
            $log.info('Edit: ' + id);
            $state.go('company.edit', {
                id: id
            });
        }

        function remove (cpm) {
            var message = 'Delete company ' + cpm.name + ' will: \n';
            message += '  - Delete all company\'s employees\n';
            message += '  - Delete all company\'s beneficial owner\n';
            var confirm = $window.confirm(message);
            if (confirm) {
                companyService.remove(cpm.id).then(function () {
                    loadCompany();
                });
            }
        }
    }
})();
