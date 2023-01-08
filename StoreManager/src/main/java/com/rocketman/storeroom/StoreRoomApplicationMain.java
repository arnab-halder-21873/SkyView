package com.rocketman.storeroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication ( exclude = DataSourceAutoConfiguration.class)
public class StoreRoomApplicationMain {
    public static void main(String[] args) {


        SpringApplication.run(StoreRoomApplicationMain.class, args);
    }
}