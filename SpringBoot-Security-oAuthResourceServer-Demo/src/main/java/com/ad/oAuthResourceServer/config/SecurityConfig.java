package com.ad.oAuthResourceServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableWebSecurity 
@EnableMethodSecurity (prePostEnabled = true)
public class SecurityConfig {

   
    private  CustomConverter customConverter;

    
    @Autowired 
    public SecurityConfig(CustomConverter customConverter) {
        this.customConverter = customConverter;
        
    }



    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorizeHttpRequests -> 
                authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/api/v1/users").permitAll()
                                    .anyRequest().authenticated()

            );

        // jwt configuration for resource server //
        http.oauth2ResourceServer(
            server -> server.jwt(jwt ->
                                    jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()) 
                                )
        );

        return http.build();

    }

    @Bean 
    public JwtAuthenticationConverter jwtAuthenticationConverter(){

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(customConverter);
        return jwtAuthenticationConverter;
    }

}
