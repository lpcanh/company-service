(function () {
    'use strict';
    angular.module('myApp.company').config(configProcess);

    configProcess.$inject = ['$stateProvider'];

    function configProcess ($stateProvider) {
        $stateProvider
            .state('company', {
                url: '/company',
                views: {
                    '@': {
                        template: '<ui-view/>'
                    }
                },
                abstract: true
            }).state('company.main', {
                url: '/main',
                templateUrl: 'js/components/company/company-main.html',
                controller: 'CompanyMainController',
                controllerAs: 'cmc',
                data: {
                    title: "Company Management"
                }
            }).state('company.create', {
                url: '/create',
                templateUrl: 'js/components/company/company-form.html',
                controller: 'CompanyFormController',
                controllerAs: 'cf',
                data: {
                    title: "Create Company"
                },
                resolve: {
                    id: function () {
                        return null;
                    },
                    form: function () {
                        return null;
                    }
                }
            }).state('company.view', {
                url: '/{id:int}',
                templateUrl: 'js/components/company/company-view.html',
                controller: 'CompanyViewController',
                controllerAs: 'cv',
                data: {
                    title: "View Company"
                },
                resolve: {
                    id: ['$stateParams', function ($stateParams) {
                        return $stateParams.id;
                    }]
                }
            }).state('company.edit', {
                url: '/{id:int}/edit',
                templateUrl: 'js/components/company/company-form.html',
                controller: 'CompanyFormController',
                controllerAs: 'cf',
                data: {
                    title: "Edit Company"
                },
                resolve: {
                    id: ['$stateParams', function ($stateParams) {
                        return $stateParams.id;
                    }],
                    form: ['$stateParams', 'companyService', function ($stateParams, companyService) {
                        return companyService.get($stateParams.id).then(function (resp) {
                            return resp.data;
                        })
                    }]
                }
            }).state('company.beneficial', {
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
                }
            });
    }
})();
