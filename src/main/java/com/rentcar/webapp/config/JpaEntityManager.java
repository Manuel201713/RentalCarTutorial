
package com.rentcar.webapp.config;

import com.rentcar.webapp.Exception.DBException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class JpaEntityManager {

	private static EntityManagerFactory emfactory = null;

	private JpaEntityManager() {}
	
	@Bean(name = "entityManagerFactory")	
	public static synchronized EntityManagerFactory getInstance() {

		try {
			if (emfactory == null) {
				emfactory = Persistence.createEntityManagerFactory("rentalcardb");
			}
			return emfactory;
		}catch(Exception e) {
			throw new DBException("Errore nel caricamento del database");
		}
	}

}


