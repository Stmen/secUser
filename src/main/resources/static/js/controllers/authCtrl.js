angular.module("userApp").controller("authCtrl", function($scope, $rootScope, $http, $location) {
	
	$scope.credentials = {};
	$scope.login = function(credentials) {

		var headers = credentials ? {authorization : "Basic "
			+ btoa(credentials.username + ":" + credentials.password)
		} : {};

		$http.get('/me', {headers : headers}).then(function(response) {
			if (response.data.name) {
				$rootScope.authenticated = true;
				$location.path("/users");
			} else {
				console.log("Aquuui");
				$scope.errorMessage = "Falha na autenticação!!";
				$rootScope.authenticated = false;
			}
		});
	};
	
	$scope.sair = function() {
		  $http.post('logout', {}).finally(function() {
		    $rootScope.authenticated = false;
		    $location.path("/");
		  });
	};

});