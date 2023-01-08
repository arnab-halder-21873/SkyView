package com.rocketman.storeroom.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/auth")
public class UploadController {

    @RequestMapping("/user")
    public ResponseEntity<String> now(){
        return ResponseEntity.ok().body("Time now is " + LocalDate.now());//"Time now is " + LocalDate.now();
    }

}



