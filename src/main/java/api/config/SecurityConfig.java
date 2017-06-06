package api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());;

	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			httpBasic()
			.and().logout()
			.and().authorizeRequests()
			.antMatchers("/bower_components/**", "/login.html", "/view/error.html", "/").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/#!/login")
			.usernameParameter("username").passwordParameter("password")
//			.and()
//			.exceptionHandling().accessDeniedPage("/")
			.and()
			.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		}

}
