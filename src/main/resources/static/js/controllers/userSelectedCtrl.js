angular.module("userApp").controller("userSelectedCtrl", function ($scope, usersAPI, userSelected, $location) {
	
	$scope.dateOptions = {
		    format: "DD/MM/YYYY",
		    locale: "pt-br"
	};
	
	$scope.app = "User Edit";	
	$scope.userSelected = userSelected.data;

	$scope.updateUser = function (userSelected) {
		usersAPI.putUser(userSelected.id, userSelected).then(function (response) {
			
			delete $scope.user;
			$scope.userForm.$setPristine(); //limpa os campos do form
			$location.path("/users");				
			
		}, function errorCallback(response) {
			$scope.messageError = "Erro no Servidor";
		});
		
	};

});