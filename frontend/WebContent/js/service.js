/**
 * PersonService to make server side calls
 */
app.factory('PersonService',function($http){
	var personService={}
	
	personService.getAllPersons=function()
	{
		//call server side code by URL
		return $http.get("http://localhost:8085/middleware/getallpersons")
	}
	
	personService.savePerson=function(person)
	{
		return $http.post("http://localhost:8085/middleware/saveperson",person)
	}
	
	personService.deletePerson=function(id)
	{
		return $http['delete']("http://localhost:8085/middleware/deleteperson/"+id);
	}
	
	personService.getPerson=function(id)
	{
		return $http.get("http://localhost:8085/middleware/getperson/"+id)
	}
	
	personService.updatePerson=function(person)
	{
		return $http.put("http://localhost:8085/middleware/updateperson",person)
	}
	
	return personService;
})
