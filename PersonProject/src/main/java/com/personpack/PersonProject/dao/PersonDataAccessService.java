package com.personpack.PersonProject.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.personpack.PersonProject.dao.PersonDao;
import com.personpack.PersonProject.model.Person;
@Repository("perdao")
public class PersonDataAccessService implements PersonDao {
	
	private static List<Person> DB = new ArrayList<Person>();

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		
		DB.add(new Person(id,person.getName()));
		return 1;
	}

	
		
	}

	
	
