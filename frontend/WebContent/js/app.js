/**
 * Angular Module
 */
var app=angular.module('app',['ngRoute'])
app.config(function($routeProvider){
	alert('entering config')
	$routeProvider
	.when('/persons',{
		templateUrl:'persons.html', //V ng-repeat="p in persons"
		controller:'PersonCtrl' //C $scope.persons
	})
	.when('/personform',{
		templateUrl:'personform.html',
		controller:'PersonCtrl'
	})
	.otherwise({templateUrl:'home.html'})
})
