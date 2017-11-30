/**
 * PersonService to make server side calls
 */
app.factory('PersonService',function($http){
	var personService={}
	
	personService.getAllPersons=function(){
		//call server side code by URL
		return $http.get("http://localhost:8085/middleware/getallpersons")
	}
	
	personService.savePerson=function(person){
		return $http.post("http://localhost:8085/middleware/saveperson",person)
	}
	return personService;
})