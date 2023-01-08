package com.rocketman.skyview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RefreshScope
//to be used wherever we will read some property value from config repo properties
public class ApiGatewayMain {
    public static void main(String[] args) {

        SpringApplication.run(ApiGatewayMain.class, args);
    }
}