package com.rocketman.storeroom.controllers;

import com.rocketman.storeroom.entity.DbObject.UserObject;
import com.rocketman.storeroom.entity.request.UserReq;
import com.rocketman.storeroom.entity.response.UserRes;
import com.rocketman.storeroom.repository.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserConfigController {

    private final UserRepository userRepo;

    public UserConfigController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRes> createUser(@RequestBody(required = true) UserReq userReq){
        UserObject user = new
                UserObject(userReq.getUsername(), userReq.getEmailId(), userReq.getPassword(),
                userReq.getLocation(), userReq.isCurLocSameAsPrimLoc());
        UserRes userRes = userRepo.saveUser(user);
        return ResponseEntity.ok().body(userRes);
    }
}
