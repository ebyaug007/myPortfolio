package com.springsec.test.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.springsec.test.Roles;

@Repository("fakeDB")
public class ListApplicationUserDaoService implements ApplicationUserDao {
	
	PasswordEncoder passwordEncoder;
	
	@Autowired
    public ListApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

	@Override
	public Optional<ApplicationUser> getApplicationUserByName(String name) {
		// TODO Auto-generated method stub
		return getApplicationUsers().stream()
				.filter(per -> name.equals(per.getUsername()))
				.findFirst();
	}
	
	 private List<ApplicationUser> getApplicationUsers() {
	        List<ApplicationUser> applicationUsers = Lists.newArrayList(
	                new ApplicationUser(
	                        "annasmith",
	                        passwordEncoder.encode("password"),
	                        Roles.USER.geGrantedAuthorities(),
	                        true,
	                        true,
	                        true,
	                        true
	                ),
	                new ApplicationUser(
	                        "linda",
	                        passwordEncoder.encode("password"),
	                        Roles.ADMIN.geGrantedAuthorities(),
	                        true,
	                        true,
	                        true,
	                        true
	                )
	        );

	        return applicationUsers;
	    }

}
