(function () {
    'use strict';
    angular
        .module('myApp.company')
        .controller('CompanyViewController', CompanyViewController);

    CompanyViewController.$inject = ['$log', 'companyService', 'BeneficialOwnerService', 'id'];

    function CompanyViewController ($log, companyService, BeneficialOwnerService, id) {
        var vm = this;
        var beneficialService = new BeneficialOwnerService(id);
        companyService.get(id).then(function (resp) {
            vm.company = resp.data;
        });
        beneficialService.getAll().then(function (resp) {
            vm.beneficials = resp.data;
        })
    }
})();