angular.module("userApp").filter("dateFormat", function() {
	return function(input) {
		
		var output = input.split("-");	
			
		return output.join("/");
	}
});