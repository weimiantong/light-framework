package org.light4j.plugin.sercurity;

import org.apache.shiro.web.env.EnvironmentLoaderListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * Created by weimiantong on 18/10/21.
 */
public class LightSecurityPlugin implements ServletContainerInitializer{
    @Override
    public void onStartup(Set<Class<?>> handlesTypes, ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("shiroConfigLocations", "classpath:light-security.ini");
        servletContext.addListener(EnvironmentLoaderListener.class);
        FilterRegistration.Dynamic lightSecurityFilter = servletContext.addFilter("LightSecurityFilter", LightSecurityFilter.class);
        lightSecurityFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
