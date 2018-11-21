package com.example.sbhi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sbhi.model.Person;



@Repository
@Transactional
public class PersonDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PersonDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public Person createPerson(Person person) {
		int isSuccess = (int)getSession().save(person);
		if(isSuccess >= 1){
			Person pers =new Person();
			pers.setCity("Sheopur");
			pers.setName("Goyal");
			updatePerson(person,1);
			Person upPer = findById(5);
			LOGGER.info("updated record [{}]",upPer);
			LOGGER.info("all record : [{}]",getAllPersons());
			deletePerosn(3);
			LOGGER.info("all record : [{}]",getAllPersons());		
			return upPer;
		}else{
			throw new RuntimeException("Person not created successfully");
		}		
	}
	
	public Person findById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Person person = session.get(Person.class, id);
		return person;	
	}
	
	public Person updatePerson(Person person,int id) {
		Session session = sessionFactory.getCurrentSession();
		Person per =  session.get(Person.class, id);
		per.setCity(person.getCity());
		per.setName(person.getName());
		
		session.update(per);
		
		return per;
	}

	public boolean deletePerosn(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person person = findById(id);
		session.delete(person);
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return getSession().createQuery("from Person").list();
	}
}
