package com.rentcar.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class TilesConfig
{
    @Bean
    public TilesConfigurer tilesConfigurer()
    {

        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        //Specifichiamo il path di dove leggere il file di configurazione dei tiles.
        tilesConfigurer.setDefinitions("/WEB-INF/layouts/definitions/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);

        return tilesConfigurer;
    }
}
