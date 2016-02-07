(function () {
    'use strict';
    angular
        .module('myApp.company')
        .controller('CompanyMainController', CompanyMainController);

    CompanyMainController.$inject = ['$log', 'companyService'];

    function CompanyMainController ($log, companyService) {
        var vm = this;
        vm.title = 'Company Main Controller';
        $log.info(vm.title);
    }
})();
