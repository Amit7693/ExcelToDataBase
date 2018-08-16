package com.amit.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Root");
		return new Class[] { Config.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("config");
		return new Class[] { Config.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("ServletMapping");
		return new String[] { "/" };
	}

}
