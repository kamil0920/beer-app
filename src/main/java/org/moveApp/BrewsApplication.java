package org.moveApp;

import org.moveApp.service.impl.IBeerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableAutoConfiguration
public class BrewsApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BrewsApplication.class, args);

        context.getBean(IBeerService.class).getAllBeers();
    }

}
