package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Person;

@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons()
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Person");//select * from person
		
		return query.list();
	}
	public void savePerson(Person person) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(person);
	}
	
	public void deletePerson(int id)
	{
		Session session=sessionFactory.getCurrentSession();
		Person person=(Person)session.get(Person.class, id);
		session.delete(person);
	}
	
	public Person getPerson(int id) 
	{
		Session session=sessionFactory.getCurrentSession();
		Person person=(Person)session.get(Person.class, id);
		return person;
	}
	
	public void updatePerson(Person person)
	{
		Session session=sessionFactory.getCurrentSession();
		session.update(person);
		
	}


}

