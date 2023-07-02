package com.emily.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

// this file is to override spring security configuration by changing the filter chain
@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //all requests should be authenticated
        //make use of http basic authentication
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

        http.httpBasic(withDefaults());

        http.csrf().disable();
        return http.build();
    }
    
}
