package com.rentcar.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc //abilitiamo spring MVC
@ComponentScan(basePackages = "com.rentcar.webapp") //va a cercare i controller in questo percorso.
public class WebApplicationContextConfig  implements WebMvcConfigurer
{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry)
    {
        //Stiamo dicendo a Spring di non usare solo le jsp ma anche i tiles.
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        //Diciamo a Spring di andare a cercare le pagine di formato .jsp nella cartella WEB-INF/view
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);

        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
