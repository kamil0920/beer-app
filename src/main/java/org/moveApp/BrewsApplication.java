package org.moveApp;

import org.moveApp.service.impl.IBeerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BrewsApplication  extends SpringBootServletInitializer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BrewsApplication.class, args);

		context.getBean(IBeerService.class).getAllBeers();
	}



	// call method when spring boot run

	// spring cron http://www.baeldung.com/cron-expressions
}
