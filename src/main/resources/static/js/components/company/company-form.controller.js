(function () {
    'use strict';
    angular
        .module('myApp.company')
        .controller('CompanyFormController', CompanyFormController);

    CompanyFormController.$inject = ['$log', 'companyService', 'id', 'form'];

    function CompanyFormController ($log, companyService, id, form) {
        $log.info('id: ' + id);
        $log.info('form: ');
        $log.info(form);
        var vm = this;
        vm.form = form || {};
        vm.submit = submit;
        vm.addEmployee = addEmployee;
        vm.removeEmployee = removeEmployee;
        vm.message = "";
        vm.errors = [];

        function submit(data){
            var savePromise;
            if(id){
                savePromise = companyService.update(id, data);
            } else{
                savePromise = companyService.create(data).then(function(resp){
                    vm.companyForm.$setPristine();
                    vm.form = {};
                    return true;
                });
            }
            savePromise.then(function(resp){
                vm.message = "Save company success";
            }, function(err){
                vm.errors = err.data;
            });
            $log.info('Submit Form');
            $log.info(data);
        }

        function addEmployee(){
            if(angular.isUndefined(vm.form.employees) || vm.form.employees === null){
                vm.form.employees = [];
            }
            vm.form.employees.push({
                name: ""
            });
        }

        function removeEmployee(index){
            vm.form.employees.splice(index, 1);
        }
    }
})();