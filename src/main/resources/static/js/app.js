angular.module("userApp", ["ngMessages", "ngRoute", "ngMaterial", "md.data.table"])
.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('blue')
    .accentPalette('red')
    .warnPalette('orange');
  
});