package api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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

}
