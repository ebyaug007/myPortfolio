package com.springsec.test;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;


public enum Roles {
	
	USER(Sets.newHashSet(Permission.PERSON_READ)),
	ADMIN(Sets.newHashSet(Permission.PERSON_READ,Permission.PERSON_WRITE));
	
	Set<Permission> permissionsToRoles; 
	
	public Set<Permission> getPermissionsToRoles() {
		return permissionsToRoles;
	}

	Roles(Set<Permission> permissionsToRoles)
	{
		this.permissionsToRoles = permissionsToRoles;
	}

	Set<SimpleGrantedAuthority> geGrantedAuthorities()
	{
		Set<SimpleGrantedAuthority> grantpermissions = getPermissionsToRoles().
				stream().map(per -> new SimpleGrantedAuthority(per.getPermission()))
				.collect(Collectors.toSet());
		grantpermissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		System.out.println(grantpermissions);
		return grantpermissions;
	}
}
