(function () {
    'use strict';
    angular
        .module('myApp.company.beneficialOwner')
        .controller('beneficialFormController', BeneficialFormController);

    BeneficialFormController.$inject = ['$log', 'BeneficialOwnerService', 'id', 'bId', 'form', '$scope'];

    function BeneficialFormController ($log, BeneficialOwnerService, id, bId, form, $scope) {
        var vm = this;
        $log.info('Beneficial Form');
        $log.info('id: ' + id + '/bId: ' + bId);
        $log.info(form);
        vm.form = form;
        vm.submit = submit;
        vm.isLoading = false;
        var beneficialOwerService = new BeneficialOwnerService(id);

        function submit(data){
            var promise;
            vm.isLoading = true;
            if(bId){
                promise = beneficialOwerService.update(bId, data);
            } else {
                promise = beneficialOwerService.create(data).then(function(resp){
                    vm.beneficialForm.$setPristine();
                    vm.form = {};
                });
            }

            promise.then(function(){
                vm.message = 'Save Beneficial success';
                $scope.$emit('update');
            }, function(err){
                vm.errors = err.data;
            }).finally(function(){
                vm.isLoading = false;
            });
        }
    }
})();
