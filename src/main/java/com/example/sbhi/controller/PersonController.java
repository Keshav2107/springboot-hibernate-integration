package com.example.sbhi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbhi.service.PersonService;
import com.example.sbhi.service.SleuthService;
import com.example.sbhi.model.Person;
import com.example.sbhi.utility.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "PersonController")
public class PersonController {

	private final PersonService personService;
	private final SleuthService sleuthService;

	/*
	 * 
	 */
	@Autowired
	public PersonController(final PersonService personService, final SleuthService sleuthService) {
		this.personService = personService;
		this.sleuthService = sleuthService;

	}

	@PostMapping(value = Constants.URI_PERSON, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(nickname = "Create person", notes = "This is a method "
			+ "for creating person", value = "create person")
	public @ResponseBody ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person per = personService.createPerson(person);
		return new ResponseEntity<>(per, HttpStatus.OK);
	}
	

}
