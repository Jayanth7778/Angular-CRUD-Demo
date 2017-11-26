package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.dao.PersonDAO;
import com.niit.model.Person;

@Controller
public class PersonController
{
	@Autowired
	private PersonDAO personDAO;
	public PersonController()
	{
		System.out.println("CREATING INSTANCE FOR PERSONCONTROLLER");
	}
	
	@RequestMapping(value="/getallpersons")
	//@ResponseBody - Data conversion
	//@ResponseBody - convert list of Java objects to array of JSON 
	public @ResponseBody List<Person> getAllPersons()
	{
		List<Person> persons=personDAO.getAllPersons();
		return persons;
	}
	
	//output - java to JSON conversion [add data to the body of the response]
	//input - JSON to java [ Http Request body]
	//{'id':0,'firstname':}
	/*@RequestMapping(value="/saveperson",method=RequestMethod.POST)
	public @ResponseBody Person savePerson(@RequestBody Person person)
	{
		personDAO.savePerson(person);
		return person;
	}*/
}
