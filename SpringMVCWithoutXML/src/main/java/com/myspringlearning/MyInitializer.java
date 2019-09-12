package com.myspringlearning;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] { MyMVCConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
