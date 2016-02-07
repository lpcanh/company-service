(function(){
    'use strict';
    angular.module('myApp.company').config(configProcess);

    configProcess.$inject = ['$stateProvider'];

    function configProcess($stateProvider){
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
            });
    }
})();
