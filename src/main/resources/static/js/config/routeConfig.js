angular.module("userApp").config(function($routeProvider, $httpProvider) {
	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	$routeProvider.when("/login", {
		templateUrl: "login.html",
		controller: "authCtrl"		
	});
	
	$routeProvider.when("/users2", {
		templateUrl: "view/users2.html",
		controller: "usersCtrl2"
	});

	$routeProvider.when("/users", {
		templateUrl: "view/users.html",
		controller: "usersCtrl"
	});

	$routeProvider.when("/newUser", {
		templateUrl: "view/formUser.html",
		controller: "userNewCtrl"
	});

	$routeProvider.when("/editUser/:id", {
		templateUrl: "view/editUser.html",
		controller: "userSelectedCtrl",
		resolve: {
			userSelected: function (usersAPI, $route) {
				return usersAPI.getUserByID($route.current.params.id);
			}
		}
	});

	$routeProvider.when("/detailUser/:id", {
		templateUrl: "view/detailUser.html",
		controller: "userSelectedCtrl",
		resolve: {
			userSelected: function (usersAPI, $route) {
				return usersAPI.getUserByID($route.current.params.id);
			}
		}
	});

	$routeProvider.when("/removeUser/:id", {
		templateUrl: "view/users.html",
		controller: "usersCtrl",
		resolve: {
			userSelected: function (usersAPI, $route) {
				return usersAPI.deleteUser($route.current.params.id);
			}
		}	
	});

	$routeProvider.when("/error", {
		templateUrl: "view/error.html"
	});

	$routeProvider.otherwise({
		redirectTo: "/login"
	});

});