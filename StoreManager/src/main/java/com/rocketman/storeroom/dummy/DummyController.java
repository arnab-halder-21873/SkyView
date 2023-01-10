package com.rocketman.storeroom.dummy;

import com.rocketman.storeroom.entity.DbObject.UserObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummy")
public class DummyController {


    @GetMapping(value = "/api", produces = MediaType.TEXT_PLAIN_VALUE )
    public ResponseEntity someDummyMethod(@RequestBody(required = false)UserObject user){
        return ResponseEntity.ok().body("Good to go");
    }
}
