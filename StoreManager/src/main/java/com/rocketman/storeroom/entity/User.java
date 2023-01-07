package com.rocketman.storeroom.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    private Long ID;

    private String name;

    private String email;

    private String password;
}
