angular.module("userApp").factory("errorInterceptor", function ($q, $location){
	return {
		responseError: function(rejection){
			
			$location.path("/error");
			return $q.reject(rejection);

		}
	};
});