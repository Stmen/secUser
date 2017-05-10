package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class SpringUserApplication extends SpringBootServletInitializer{
	
	private static Class<SpringUserApplication> applicationClass = SpringUserApplication.class;

	/**
	 * Método main do spring boot que levanta um tomcat embed
	 * @param args Argumentos da chamada
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringUserApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

}
