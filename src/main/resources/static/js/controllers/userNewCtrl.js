angular.module("userApp").controller("userNewCtrl", function ($scope, usersAPI){

	$scope.newUser = function (user) {
		var dataFormatada = user.dateOfBirth.getDay()+"/"+user.dateOfBirth.getMonth()+"/" +user.dateOfBirth.getFullYear();
		console.log(dataFormatada);

		usersAPI.postUser(user).then(function (response) {			
			
			delete $scope.user;
			$scope.userForm.$setPristine(); //limpa os campos do form
			$scope.userForm.username = "";
			$scope.messageSuccess = "Usuário "+ user.name +" foi adicionado com "		
		
		}, function errorCallback(response) {
			$scope.messageError = "Erro no Servidor "+response.data;
		});
		
	};
}).config(function($mdDateLocaleProvider) {
  $mdDateLocaleProvider.formatDate = function(date) {
    return moment(date).format('DD/MM/YYYY');
  };
});