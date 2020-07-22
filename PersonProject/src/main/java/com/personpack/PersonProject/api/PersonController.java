package com.personpack.PersonProject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personpack.PersonProject.model.Person;
import com.personpack.PersonProject.service.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
	
	private final PersonService ps;
	@Autowired
	public PersonController(PersonService ps) {
		// TODO Auto-generated constructor stub
		this.ps = ps;
	}
	@PostMapping
	public void addPerson(@RequestBody Person p)
	{
		ps.insertPerson(p);
	}
	

}
