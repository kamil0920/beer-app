package org.moveApp;

import org.moveApp.service.impl.IBeerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
public class BrewsApplication extends SpringBootServletInitializer {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BrewsApplication.class, args);

        context.getBean(IBeerService.class).getAllBeers();


    }

}
