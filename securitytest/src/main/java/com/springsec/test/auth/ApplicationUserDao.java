package com.springsec.test.auth;

import java.util.Optional;

public interface ApplicationUserDao {

	Optional<ApplicationUser> getApplicationUserByName(String name);
}
