package com.springsec.test;

public enum Permission {
	
	PERSON_READ("person:read"),
	PERSON_WRITE("person:write");
	
	String permission;
	
	Permission(String b)
	{
		this.permission = b;
	}

	public String getPermission() {
		return permission;
	}
	

}
