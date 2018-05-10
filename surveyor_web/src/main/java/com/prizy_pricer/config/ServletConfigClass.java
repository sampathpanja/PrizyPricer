package com.prizy_pricer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.prizy_pricer.command", "com.prizy_pricer.controller", "" })
@Import(value = { SurveyorSecurityConfig.class })
@EnableWebMvc
public class ServletConfigClass extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/product-list.htm").setViewName("product-list");

		registry.addViewController("/surveyorlogin.htm").setViewName("surveyorlogin");
		registry.addViewController("/surveyorhome.htm").setViewName("surveyorhome");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

}
