(function () {
    'use strict';
    angular
        .module('myApp.company.beneficialOwner')
        .config(configProcess);

    configProcess.$inject = ['$stateProvider'];

    function configProcess ($stateProvider) {
        $stateProvider.
            state('company.beneficial', {
                url: '/{id:int}/beneficial',
                templateUrl: 'js/components/company/beneficial-owner/beneficial-owner-main.html',
                controller: 'beneficialMainController',
                controllerAs: 'bo',
                data: {
                    title: "Company Beneficial Management"
                },
                resolve: {
                    id: ['$stateParams', function ($stateParams) {
                        return $stateParams.id;
                    }]
                },
                params: {
                    company: {}
                }
            }).state('company.beneficial.create', {
                url: '/create',
                views: {
                    "beneficialForm": {
                        templateUrl: 'js/components/company/beneficial-owner/beneficial-owner-form.html',
                        controller: 'beneficialFormController',
                        controllerAs: 'bF'
                    }
                },
                resolve: {
                    id: ['$stateParams', function ($stateParams) {
                        return $stateParams.id;
                    }],
                    bId: ['$stateParams', function ($stateParams) {
                        return $stateParams.bId;
                    }],
                    form: function () {
                        return {};
                    }
                }
            }).state('company.beneficial.edit', {
                url: '/{bId:int}/edit',
                views: {
                    "beneficialForm": {
                        templateUrl: 'js/components/company/beneficial-owner/beneficial-owner-form.html',
                        controller: 'beneficialFormController',
                        controllerAs: 'bF'
                    }
                },
                resolve: {
                    id: ['$stateParams', function ($stateParams) {
                        return $stateParams.id;
                    }],
                    bId: ['$stateParams', function ($stateParams) {
                        return $stateParams.bId;
                    }],
                    form: ['$stateParams', '$log', 'BeneficialOwnerService', function ($stateParams, $log, BeneficialOwnerService) {
                        $log.info($stateParams);
                        var beneficialOwnerService = new BeneficialOwnerService($stateParams.id);
                        return beneficialOwnerService.get($stateParams.bId).then(function (resp) {
                            return resp.data;
                        });
                    }]
                }
            });
    }
})();
