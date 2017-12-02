package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.PersonDAO;
import com.niit.model.ErrorClazz;
import com.niit.model.Person;

@Controller
public class PersonController
{
	@Autowired
	private PersonDAO personDao;
	public PersonController()
	{
		System.out.println("CREATING INSTANCE FOR PERSON CONTROLLER");
	}
	
	@RequestMapping(value="/getallpersons",method=RequestMethod.GET)
	//@ResponseBody - Data conversion
	//@ResponseBody - convert list of Java objects to array of JSON 
	public @ResponseBody List<Person> getAllPersons()
	{
		List<Person> persons=personDao.getAllPersons();
		return persons;
	}
	
	//output - java to JSON conversion [add data to the body of the response]
	//input - JSON to java [ Http Request body]
	//{'id':0,'firstname':}
	@RequestMapping(value="/saveperson",method=RequestMethod.POST)
	public @ResponseBody Person savePerson(@RequestBody Person person)
	{
		personDao.savePerson(person);
		return person;
	}
	
	@RequestMapping(value="/deleteperson/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable int id)
	{		
		try
		{
			personDao.deletePerson(id);
		}
		catch(Exception e)
		{
			ErrorClazz error=new ErrorClazz(1,"Person with " + id+ " doesn't exists");
			return new ResponseEntity<ErrorClazz>(error,HttpStatus.NOT_FOUND);
			// 2nd call back function [Error function]
			//response.data = ErrorClazz obj in JSON
			//response.status=HttpStatus.NOT_FOUND 404
		}		
		
		List<Person> persons=personDao.getAllPersons();
		return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);
		//1st call back function [Success function
		//response.data= List<Person> in JSON
		//response.status= HttpStatus.OK, 200
	}
}