package com.prizy_pricer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.prizy_pricer.controller", "com.prizy_pricer.command" })
@EnableWebMvc
public class ServletConfigClass extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/home.htm").setViewName("home");
		registry.addViewController("/adminlogin.htm").setViewName("adminlogin");
		registry.addViewController("/adminhome.htm").setViewName("adminhome");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}
