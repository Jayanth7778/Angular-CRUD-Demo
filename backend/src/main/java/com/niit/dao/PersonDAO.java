package com.niit.dao;

import java.util.List;

import com.niit.model.Person;

public interface PersonDAO
{
	List<Person> getAllPersons();
	void savePerson(Person person);
	void deletePerson(int id);

}
