angular.module("userApp").config(function ($httpProvider) {
	$httpProvider.interceptors.push("errorInterceptor");
	
});