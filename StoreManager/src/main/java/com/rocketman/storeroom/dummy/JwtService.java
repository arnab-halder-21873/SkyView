package com.rocketman.storeroom.dummy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.algorithms.Algorithm;
@Service
public class JwtService {

    @Value("${hmac.secret-key}")private String hmacSecret;

    private static final String issuer ="";
    private static final String audience ="";
    private String custom_claim_storage_drive ="";
    private String custom_claim_storage_folder ="";
    private String custom_claim_storage_directory ="";
    private String custom_claim_storage_file ="";

    public String createToken(){
        return null;
    }



}
