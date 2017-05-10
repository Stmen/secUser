angular.module("userApp").controller("usersCtrl2", function ($scope, usersAPI){
	
	$scope.app = "User App";
	$scope.users = [];
	
	var usersSelected = [];

	var allUsers = function() {

		usersAPI.getUsers().then(function (response) {

			$scope.users = response.data;
			
		}, function errorCallback(response) {
			$scope.messageError = "Erro de conexão";
		});

	};

	$scope.deleteUser = function (users) {
		var usernames = "";
		$scope.hasUserSelected = true; // Desabilitando o botao Remover
		for (var i = users.length - 1; i >= 0; i--) {

			if (users[i].selected) {
				usernames += " '"+users[i].name +"' ";
				usersAPI.deleteUser(users[i].id).then(function (response) {
				
				$scope.messageSuccess = "Usuário(s): "+ usernames +" removido(s) com"									
				allUsers(); // refresh dos usuarios
			});			
		}
			
		};
	};

	$scope.checkUserSelected = function (user) {		
		
		user.selected = !user.selected;
		$scope.hasUserSelected = user.selected;

		// $scope.hasUserSelected = users.some(function (user) {
		//  	return user.selected;
		// });
	};

	allUsers();
	
});