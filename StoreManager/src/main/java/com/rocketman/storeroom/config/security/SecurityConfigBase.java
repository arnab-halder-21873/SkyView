package com.rocketman.storeroom.config.security;

import com.rocketman.storeroom.entity.User;
import com.rocketman.storeroom.repository.UserRepository;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfigBase {

    public UserRepository userRepo;

    public FilterRegistrationBean<CustomBasicFilter> registerFilter() {

        var frb = new FilterRegistrationBean<CustomBasicFilter>();

        frb.setFilter(new CustomBasicFilter());
        frb.addUrlPatterns("/auth/user");

        return frb;
    }
}
