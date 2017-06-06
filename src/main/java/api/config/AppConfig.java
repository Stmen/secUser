package api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/login").setViewName("/#!/login");
//		registry.addViewController("/403").setViewName("403");
//		registry.addViewController("/error").setViewName("error");
//
//	}
	
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//    	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//    	resolver.setPrefix("/view/");
//    	resolver.setSuffix(".html");
//    	return resolver;
//
//    }  
    
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/userSec");
		dataSource.setUsername("root");
		dataSource.setPassword("bsi2009");
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
