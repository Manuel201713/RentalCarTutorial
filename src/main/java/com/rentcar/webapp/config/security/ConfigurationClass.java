package com.rentcar.webapp.config.security;

import com.rentcar.webapp.config.JpaEntityManager;
import com.rentcar.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableJpaRepositories(value = {"com.rentcar.webapp.repository"})
public class ConfigurationClass extends WebSecurityConfigurerAdapter {
	
    @Primary
    @Bean(name="transactionManager")
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(JpaEntityManager.getInstance());
        return transactionManager;
    }
	
	@Autowired
	private UserService userDetailsService;

	private static final String[] ADMIN_CATEGORY_MATCHER =
			{
					"/users/add/**",
					"/users/update/**",
					"/users/delete/**",
					"/vehicle/add/**",
					"/vehicle/update/**",
					"/vehicle/delete/**",
					"/rental/add/**",
					"/rental/update/**",
					"/rental/delete/**",
					"/rentals/**"
			};

	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http
				.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers("/login/**").permitAll()
				.antMatchers("/").hasAnyRole("ANONYMOUS", "USER")
				.antMatchers(ADMIN_CATEGORY_MATCHER).access("hasRole('ADMIN')")
				.antMatchers("/users/**").hasRole("USER")
				.antMatchers("/vehicles/**").hasRole("USER")
				.and()
				.formLogin()
				.loginPage("/login/form")
				.loginProcessingUrl("/login")
				.failureUrl("/login/form?error")
				.usernameParameter("userId")
				.passwordParameter("password")
				.and()
				.exceptionHandling()
				.accessDeniedPage("/login/form?forbidden")
				.and()
				.logout()
				.logoutUrl("/login/form?logout");
		//.and().csrf().disable();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//Questo Override serve per isolare l'autenticazione dalle API
		super.configure(web);
		web.ignoring().antMatchers("/api/**");
	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return encode(rawPassword).equals(encodedPassword);
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}
}
