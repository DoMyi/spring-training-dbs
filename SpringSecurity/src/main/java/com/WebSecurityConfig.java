package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan("com")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@SuppressWarnings("deprecation")
	@Bean
	public UserDetailsService userDetailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withDefaultPasswordEncoder().username("sachin").password("test123").roles("ADMIN").build());
		manager.createUser(User.withDefaultPasswordEncoder().username("mercy").password("test123").roles("ADMIN").build());
		return manager;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("sachin").authenticated()
		.and().formLogin()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
}
