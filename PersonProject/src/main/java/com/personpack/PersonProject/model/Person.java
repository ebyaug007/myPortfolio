package com.personpack.PersonProject.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private UUID id;
	private String name;
	public UUID getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Person(@JsonProperty("id")UUID id, @JsonProperty("name")String name)
	{
		this.id= id;
		this.name = name;
	}
}
