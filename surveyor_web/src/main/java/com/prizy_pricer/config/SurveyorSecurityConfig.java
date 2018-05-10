package com.prizy_pricer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SurveyorSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("dev").password("dev123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers(new String[] { "/home.htm", "/contact-us.htm", "/surveyorhome.htm" })
				.access("hasRole('USER')").and().formLogin().loginPage("/surveyorlogin.htm")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username")
				.passwordParameter("j_password").defaultSuccessUrl("/surveyorhome.htm", true)
				.failureHandler(newAuthenticationFailureHandler()).and().logout().logoutUrl("/surveyorlogout")
				.logoutSuccessUrl("http://localhost:8083/surveyor_web/").invalidateHttpSession(true);

		http.csrf().disable();
	}

	public ExceptionMappingAuthenticationFailureHandler newAuthenticationFailureHandler() {
		ExceptionMappingAuthenticationFailureHandler failureHandler = new ExceptionMappingAuthenticationFailureHandler();

		Map<String, String> failureUrlMap = new HashMap<String, String>();

		failureUrlMap.put("org.springframework.security.authentication.BadCredentialsException",
				"/login.htm?error=badCredentails");

		failureHandler.setExceptionMappings(failureUrlMap);

		return failureHandler;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// Spring Security should completely ignore URLs starting with /resources/
		web.ignoring().antMatchers("/product-list.htm");
	}

}