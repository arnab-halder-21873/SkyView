package com.rocketman.storeroom.entity.request;

import lombok.Data;

import java.util.function.Predicate;

@Data
public class UserReq {

    private String username;

    private String emailId;

    private char[] password;

    private String location;

    private boolean curLocSameAsPrimLoc;

}
