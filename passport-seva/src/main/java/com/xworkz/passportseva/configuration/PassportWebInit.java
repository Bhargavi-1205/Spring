package com.xworkz.passportseva.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PassportWebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{PassportConfiguration .class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
