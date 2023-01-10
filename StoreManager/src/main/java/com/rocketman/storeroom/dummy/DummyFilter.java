package com.rocketman.storeroom.dummy;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.http.HttpHeaders;

//@Configuration
public class DummyFilter extends OncePerRequestFilter {


    /*@Autowired
    public UserRepository userRepo;*/


    /*public CustomBasicFilter(UserRepository userRepo) {
        this.userRepo = userRepo;
    }*/


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authenticationCredentials = request.getHeader(HttpHeaders.AUTHORIZATION); //request.getAuthType();
        // Fetch the credentials Header that is passed in the request.
        // When we do Basic Authentication, it is passed as a request header. like -> BASIC <encoded value>


        if (!authenticationCredentialsValid(authenticationCredentials)) {
            System.out.println("Request not proceeding");

            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write("Invalid details");
            response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "Proper Credentials not given"); //Is a bad practice???? Allows saved passwords to be reused??
        } else
            filterChain.doFilter(request, response);
        System.out.println("Request proceeding");



    }

    private boolean authenticationCredentialsValid(String authenticationCredentials) {

        if (authenticationCredentials.isBlank()) return false;
        else return true;
    }
}
