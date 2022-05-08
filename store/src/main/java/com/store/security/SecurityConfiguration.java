package com.store.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.store.security.filter.AuthenticationFilter;
import com.store.security.service.AuthenticationService;
import com.store.security.service.UserService;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private final UserService userService;

	private final AuthenticationService authenticationService;

	public SecurityConfiguration( UserService userService, @Lazy AuthenticationService authenticationService) {
		this.userService = userService;
		this.authenticationService = authenticationService;
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
		.antMatchers("/v1/auth/**").permitAll()
		.antMatchers(HttpMethod.GET, "/v1/customer/**").authenticated()
		.antMatchers(HttpMethod.POST, "/v1/customer/**").permitAll()
		.antMatchers(HttpMethod.GET, "/v1/product/**").permitAll()
		.antMatchers(HttpMethod.POST, "/v1/product/**").authenticated()
		.antMatchers("v1/sales").authenticated()
		.antMatchers("/h2/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(new AuthenticationFilter(authenticationService, userService), UsernamePasswordAuthenticationFilter.class);

		
		http.csrf().disable();
        http.headers().frameOptions().disable();
	}
}
