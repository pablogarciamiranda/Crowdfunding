package ie.cit.adf.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
			.antMatchers("/main").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
			.antMatchers("/update_user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
			.antMatchers("/login").permitAll()
			.antMatchers("/sign_up/**").permitAll()
			.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/")
				.failureUrl("/login?error")				
			.and()
				.logout()
				.logoutSuccessUrl("/login?logout");
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

}