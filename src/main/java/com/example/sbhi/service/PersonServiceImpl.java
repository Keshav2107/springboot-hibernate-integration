package com.example.sbhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sbhi.dao.PersonDAO;
import com.example.sbhi.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonDAO personDao;
	
	@Autowired
	public PersonServiceImpl(PersonDAO personDao) {
		this.personDao = personDao;
	}
	
	@Override
	public Person createPerson(Person person) {
		
		return personDao.createPerson(person);
		
	}

}
