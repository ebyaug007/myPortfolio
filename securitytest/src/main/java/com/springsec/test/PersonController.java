package com.springsec.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	public static List<Person> per = new ArrayList<Person>(Arrays.asList(new Person(1,"JohnDoe")
			,new Person(2,"JaneDoe"),new Person(3,"Billy")));

	@GetMapping
	@PreAuthorize("hasAuthority('person:write')")
	public List<Person> getAllPerson()
	{
		return per;
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('person:write')")
	public void insertPerson(@RequestBody Person p)
	{
		per.add(p);
	}
	@DeleteMapping("{id}")
	@PreAuthorize("hasAuthority('person:write')")
	public void removePerson(@PathVariable("id") Integer id)
	{
		per.removeIf(p -> id.equals(p.getId()));
		
	}
	@GetMapping("{id}")
	@PreAuthorize("hasAuthority('person:read')")
	public Optional<Person> getPersonById(@PathVariable("id") Integer id)
	{
		return per.stream()
				.filter(p -> id.equals(p.getId())).findFirst();
	}
}
