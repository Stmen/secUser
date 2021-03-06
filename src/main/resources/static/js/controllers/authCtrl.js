angular.module("userApp").controller("authCtrl", function($rootScope, $scope, $http, $location) {

	$scope.credentials = {};
	$scope.login = function(credentials) {
		var headers = credentials ? {authorization : "Basic "
			+ btoa(credentials.username + ":" + credentials.password)
		} : {};

		$http.get("whoami", {headers : headers}).then(function(response) {
			if (response.data.authenticated) {
				$rootScope.authenticated = true;
				console.log("Login OK");
				$scope.errorMessage = false;
				$location.path("/users");
			} else {
				$location.path("/login");
				$rootScope.authenticated = false;
				console.log("Login Error");
				$scope.errorMessage = true;
			} 
		},  function errorCallback(response) {
			$rootScope.authenticated = false;
			console.log("Login Error Callback");
			$scope.errorMessage = true;
		});

	};
	
});