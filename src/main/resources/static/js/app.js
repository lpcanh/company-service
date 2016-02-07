(function(){
    'use strict';

    angular
        .module('myApp', [
            'ui.router',
            'myApp.company'
        ]).config(mainConfigure);

    mainConfigure.$inject = ['$urlRouterProvider'];

    function mainConfigure ($urlRouterProvider) {
        $urlRouterProvider.otherwise('/company/main');
    }
})();
