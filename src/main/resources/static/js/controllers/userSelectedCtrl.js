angular.module("userApp").controller("userSelectedCtrl", function ($scope, usersAPI, userSelected, $location) {
	
	$scope.app = "User Form";	
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