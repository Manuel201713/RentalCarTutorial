package com.rentcar.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //abilita la gestione delle transazioni
@ComponentScan({ "com.rentcar.webapp.config" }) //Dice a Spring di cercare qua le classi di configurazione
@PropertySource(value = { "classpath:application.properties" }) //Serve a JdbcConfig di accedere al file di configurazione specificato
public class JdbcConfig
{
    @Autowired
    private Environment environment;// serve per accedere ai valori inseriti al file application.properties

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource)
    {
        //per creare la connessione jdbc
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource)
    {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource dataSource()

            //Ci permette di leggere i parametri del file application.properties
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));

        return dataSource;
    }
/*
    @Bean
    public DataSourceTransactionManager transactionManager()
    {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }

 */

}
