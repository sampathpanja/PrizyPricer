package com.pp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.pp.service", "com.pp.dao", "com.pp.entities" })
@Import(value = { PersistencyConfig.class })
public class ServiceConfig {

}
