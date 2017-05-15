angular.module("userApp").controller("authCtrl", function($scope, $rootScope, $http, $location) {

	$scope.login = function(credentials) {

		var headers = credentials ? {authorization : "Basic "
			+ btoa(credentials.username + ":" + credentials.password)
		} : {};

		$http.get('/me', {headers : headers}).then(function(response) {
			if (response.data.name) {
				$rootScope.authenticated = true;
				$location.path("/users");
			} else {
				$location.path("/login");
				$rootScope.authenticated = false;
				$scope.error = true;
			}
		});
	};

});