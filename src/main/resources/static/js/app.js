(function(){
    'use strict';

    angular
        .module('myApp', [
            'ui.router',
            'ngMessages',
            'myApp.company'
        ]).config(mainConfigure);

    mainConfigure.$inject = ['$urlRouterProvider'];

    function mainConfigure ($urlRouterProvider) {
        $urlRouterProvider.otherwise('/company/main');
    }

    angular
        .module('myApp')
        .run(runFn);

    runFn.$inject = ['$rootScope', '$log'];

    function runFn($rootScope, $log){
        $log.info('Run function');
        var stateChangeStart = $rootScope.$on('$stateChangeStart', stateChangeStart);
        var stateNotFoundEvent = $rootScope.$on('$stateNotFound', stateNotFound);
        var stateChangeSuccessEvent = $rootScope.$on('$stateChangeSuccess', stateChangeSuccess);
        var stateChangeErrorEvent = $rootScope.$on('$stateChangeError', stateChangeError);

        function stateChangeStart (stateEvent, toState) {
        }

        function stateNotFound(stateEvent, unfoundState){
            $log.info('State not found');
            $log.info(unfoundState);
        }
        function stateChangeError (stateEvent, toState, toParams, fromState, fromParams, error) {
            $log.info('State change error');
            $log.info(fromState);
            $log.info(fromParams);
            $log.info(error);
        }
        function stateChangeSuccess (stateEvent, toState) {
            $log.info('State change success');
            $log.info(toState);
            $rootScope.title = '';
            if(toState.data && toState.data.title){
                $rootScope.title = toState.data.title;
            }
        }
    }
})();
