package com.lms.eurekaserver;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Service Registry and Discovery Server using Netflix Eureka.
 *
 * @EnableEurekaServer configures the registry cache, heartbeat handlers,
 * and the browser-based Eureka Dashboard.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}