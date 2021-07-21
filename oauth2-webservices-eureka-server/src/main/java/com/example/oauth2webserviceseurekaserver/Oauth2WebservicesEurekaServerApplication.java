package com.example.oauth2webserviceseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Oauth2WebservicesEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2WebservicesEurekaServerApplication.class, args);
    }

}
