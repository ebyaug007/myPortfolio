package com.personpack.PersonProject.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.personpack.PersonProject.model.Person;

public interface PersonDao {
	
	int insertPerson(UUID id, Person person);
	
	default int addPerson(Person person)
	{
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

}
