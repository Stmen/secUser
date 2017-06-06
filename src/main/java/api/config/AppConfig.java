package api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private Environment environment;

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.environment.getProperty("spring.datasource.driver"));
		dataSource.setUrl(this.environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(this.environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(this.environment.getProperty("spring.datasource.password"));
		return dataSource;

	}
	
	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService(){
		JdbcDaoImpl jdbcImpl = new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource());
		jdbcImpl.setUsersByUsernameQuery("select username,password, enabled from users where username=?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select b.username, a.role from user_roles a, users b where b.username=? and a.username=b.username");
		return jdbcImpl;
	}

}
