/**
 * PersonService to make server side calls
 */
app.factory('PersonService',function($http){
	var personService={}
	
	personService.getAllPersons=function()
	{
		//call server side code by URL
		return $http.get("http://localhost:8080/middleware/getallpersons")
	}
	
	personService.savePerson=function(person)
	{
		return $http.post("http://localhost:8080/middleware/saveperson",person)
	}
	
	personService.deletePerson=function(id)
	{
		return $http['delete']("http://localhost:8080/middleware/deleteperson/"+id);
	}
	return personService;
})
