package mk.learning.employeeapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mk.learning.employeeapp.controllers.BasicRestController;
import mk.learning.employeeapp.services.BasicService;

/*
 * Any class annotated with @Configuration will be executed before any other class. this is done so since these classes contain bean definitions
 * 
 * what is the need of these classes?
 * these configurations can be controlled based on run profile of the application
 */
@Configuration
public class ApplicationConfig {

	@Bean
	@Profile("dev")
	public BasicService getBasicServiceBean() {
		return new BasicService();
	}
	
	@Bean
	@Profile("prod")
	public BasicService getBasicServiceBean4Prod() {
		//have some other logic to create a BasicService object
		return new BasicService();
	}
	
}
