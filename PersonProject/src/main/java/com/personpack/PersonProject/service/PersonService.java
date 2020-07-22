package com.personpack.PersonProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.personpack.PersonProject.dao.PersonDao;
import com.personpack.PersonProject.model.Person;

@Service
public class PersonService {
	private final PersonDao pd;
	public int insertPerson(Person p)
	{
		return pd.addPerson(p);
	}
	@Autowired
	PersonService(@Qualifier("perdao") PersonDao personDao)
	{
		pd = personDao;
	}
}
