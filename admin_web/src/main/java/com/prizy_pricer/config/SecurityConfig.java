package com.prizy_pricer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(new String[] { "/adminhome.htm", "/product-list.htm", "/add-product.htm",
						"/update-product.htm", "/modified-product-details.htm" })
				.access("hasRole('ADMIN')").and().formLogin().loginPage("/adminlogin.htm")
				.loginProcessingUrl("/j_spring_security_check").usernameParameter("j_username")
				.passwordParameter("j_password").defaultSuccessUrl("/adminhome.htm", true)
				.failureHandler(newAuthenticationFailureHandler()).and().logout().logoutUrl("/adminlogout")
				.logoutSuccessUrl("http://localhost:8083/admin_web/").invalidateHttpSession(true);

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

}