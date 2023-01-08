package com.rocketman.skyview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
                                    SecurityAutoConfiguration.class,
                                    ManagementWebSecurityAutoConfiguration.class})
//we have to pass in the username and password when we try to register the service as an Eureka Client.
//SO Eureka Server (and clients) can exclude the security configurations
@EnableEurekaServer
public class DiscoveryServerMain {
    public static void main(String[] args) {

        SpringApplication.run(DiscoveryServerMain.class, args);
    }
}