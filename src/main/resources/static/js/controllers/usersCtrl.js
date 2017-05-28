angular.module("userApp").controller("usersCtrl", function ($scope, $rootScope, $location, $http, usersAPI){

	$scope.app = "User App";
	$scope.users = [];
	$scope.paging = {};

	var page = 0;
	$scope.disablebackPagination = true;
	$scope.disablenextPagination = false;
	
	var allUsers = function(page) {
		usersAPI.getUsers(page).then(function (response) {
			$scope.users = response.data.content;
			$scope.paging.totalPages = response.data.totalPages;
			$scope.paging.number = response.data.number;
			// Todos os elementos em uma unica pagina
			if ($scope.paging.totalPages == 1) {
				$scope.disablenextPagination = true;
			}
			
		}, function errorCallback(response) {
			$scope.messageError = "Erro de conexão";
			$location.path("/login");
		});

	};

	$scope.nextPage = function (){
		page++;
		if (page === $scope.paging.totalPages-1) {
			$scope.disablebackPagination = false;
			$scope.disablenextPagination = true;
		}
		allUsers(page);
	}
	
	$scope.backPage = function (){
		page--;
		if (page === 0) {
			$scope.disablebackPagination = true;
			$scope.disablenextPagination = false;
		}
		allUsers(page);
	}

	$scope.sair = function() {
			$http.post('logout', {}).finally(function() {
				$rootScope.authenticated = false;
			});
			$location.path("/");
		};
	
	allUsers(0);
});