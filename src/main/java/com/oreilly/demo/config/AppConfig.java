package com.oreilly.demo.config;

import com.oreilly.demo.json.Greeting;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Scope;

import java.util.logging.Logger;

@Configuration
public class AppConfig {

    @Bean
    public Greeting defaultGreeting(){
        return new Greeting("Hello World");
    }
    @Bean
    public Greeting whatUpGreeting(){

        return new Greeting("What up?");
    }

    @Bean
    @Scope("prototype")
    public Logger logger(@Autowired InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    //  not needed if gradle has
    //    implementation 'org.springframework.boot:spring-boot-starter-web'
    //    @Bean
    //    public RestTemplateBuilder restTemplate() {
    //        return new RestTemplateBuilder();
    //    }
}
