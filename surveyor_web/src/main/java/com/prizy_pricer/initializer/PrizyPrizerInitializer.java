package com.prizy_pricer.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.prizy_pricer.config.RootConfigClass;
import com.prizy_pricer.config.ServletConfigClass;

public class PrizyPrizerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfigClass.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletConfigClass.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}

}
