package com.example.oauth2webservicesalbumsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Oauth2WebservicesAlbumsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2WebservicesAlbumsServiceApplication.class, args);
    }

}
