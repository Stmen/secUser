angular.module("userApp").factory("usersAPI", function ($http, config){

	var path = "/users";

	var _getUsers = function () {		
		return $http.get(config.baseUrl+path);
	};

	var _getUserByID = function (userID) {
		return $http.get(config.baseUrl+path+"/"+userID);
	};

	var _postUsers = function (user) {
		return $http.post(config.baseUrl+path, user)
	};

	var _deleteUser = function (userID) {
		return $http.delete(config.baseUrl+path+"/"+userID)
	};

	var _putUser = function (userID, user) {
		return $http.put(config.baseUrl+path+"/"+userID, user)
	};

	return {
		getUsers: _getUsers,
		getUserByID: _getUserByID,
		postUser: _postUsers,
		deleteUser: _deleteUser,
		putUser: _putUser
	};
});