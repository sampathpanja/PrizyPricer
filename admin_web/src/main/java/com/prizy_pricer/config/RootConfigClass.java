package com.prizy_pricer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.pp.config.PersistencyConfig;
import com.pp.config.ServiceConfig;

@Configuration
@Import(value = { ServletConfigClass.class, SecurityConfig.class, ServiceConfig.class, PersistencyConfig.class })
@ComponentScan(basePackages = { "com.prizy_pricer.controller", "com.prizy_pricer.command", "com.pp.service",
		"com.prizy_pricer.bo" })
public class RootConfigClass {

}
