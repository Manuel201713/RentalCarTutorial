package com.rentcar.webapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]
                {
                        //specifichiamo la classe di configurazione generale

                        WebApplicationContextConfig.class
                };
    }

    @Override
    protected String[] getServletMappings()
    {
        //qualsiasi chiamata verrà gestita dal dispatcherservlet
        return new String[] { "/" };
    }

}
