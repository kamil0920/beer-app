package org.moveApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BrewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrewsApplication.class, args);
	}
}
