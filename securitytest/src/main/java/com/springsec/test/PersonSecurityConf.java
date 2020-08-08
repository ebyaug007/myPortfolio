package com.springsec.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class PersonSecurityConf extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","index").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll() 
			.defaultSuccessUrl("/firstpage",true)
		  .and() 
		  .rememberMe()
		 ;
		
			//.httpBasic();
	}
	
	@Bean
	PasswordEncoder justToCreateABean()
	{
		return new BCryptPasswordEncoder(10);
	}
	
	@Autowired
	PasswordEncoder ps;
	
	private String encodeYourPassword(String pass)
	{
		return ps.encode(pass);
	}
	
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		// TODO Auto-generated method stub
		UserDetails user1 = User.builder().username("eby")
					.password(encodeYourPassword("pass123"))
					.authorities(Roles.USER.geGrantedAuthorities())
					.build();
		
		UserDetails user2 = User.builder().username("john")
				.password(encodeYourPassword("pass123"))
				.authorities(Roles.ADMIN.geGrantedAuthorities())
				.build();
	
		return new InMemoryUserDetailsManager(user1,user2);
	}

}
