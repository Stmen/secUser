angular.module("userApp").controller("usersCtrl", function ($scope, usersAPI){
	
	$scope.app = "User App";
	$scope.users = [];
	$scope.selected = [];

	$scope.query = {
    	order: 'name',
    	limit: 5,
    	page: 1
  	};

  	function success(users) {
    	$scope.users = users;
  	}
  
	var usersSelected = [];

	var allUsers = function() {

		usersAPI.getUsers().then(function (response) {

			$scope.users = response.data;
			
		}, function errorCallback(response) {
			$scope.messageError = "Erro de conexão";
		});

	};

	allUsers();
	
});