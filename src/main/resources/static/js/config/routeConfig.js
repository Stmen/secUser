angular.module("userApp").config(function($routeProvider) {
	
	$routeProvider.when("/login", {
		templateUrl: "view/login.html",
		controller: "loginCtrl"		
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