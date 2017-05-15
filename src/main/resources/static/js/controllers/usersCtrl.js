angular.module("userApp").controller("usersCtrl", function ($scope, $rootScope, $location, $http, usersAPI){
	
	$scope.app = "User App";
	$scope.users = [];
	$scope.selected = [];

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
	
	$scope.sair = function() {
		  $http.post('logout', {}).finally(function() {
		    $rootScope.authenticated = false;
		    $location.path("/login");
		  });
	};
	
});