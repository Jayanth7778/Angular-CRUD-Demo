/**
 * EditPersonController 
 *  getperson/1
 *  getperson/450
 *  getperson/452
 *  getperson/:id
 */
app.controller('EditPersonController',function($scope,PersonService,$routeParams,$location){
	var pid=$routeParams.id
	
	PersonService.getPerson(pid).then(function(response){
		$scope.person=response.data  //select * from person where id=?,person in JSON format
	},function(response){
		console.log(response.status)
	})
	
	$scope.updatePerson=function(){
		PersonService.updatePerson($scope.person).then(function(response){
			$scope.person={}
			alert('Person details gets updated successfully');
			$location.path('/persons')
		},function(response){
			console.log(response.status)
		})
	}
})
