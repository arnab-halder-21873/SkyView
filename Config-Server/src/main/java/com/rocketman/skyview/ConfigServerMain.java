package com.rocketman.skyview;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        ManagementWebSecurityAutoConfiguration.class})
@EnableEurekaClient
@EnableConfigServer
//@CircuitBreaker(name="api-gateway", fallback=fallbackApiGateway)
//Need to annotate where we will call the method of <name> service,
//and define the fallback with the method name and signature of caller method.
public class ConfigServerMain {
    public static void main(String[] args) {

        SpringApplication.run(ConfigServerMain.class, args);
    }
}