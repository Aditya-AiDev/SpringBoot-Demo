package com.ad.oAuthResourceServer.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component 
public class CustomConverter implements  Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection convert(Jwt source) {
        Map<String,Object> realmAccess= (Map<String, Object>) source.getClaims().get("realm_access");

        if (realmAccess == null || !realmAccess.containsKey("roles")) {
            return Collections.emptyList();
        }

        List<String> roles = (List<String>) realmAccess.get("roles");

        

        List<SimpleGrantedAuthority> roleList = roles.stream()
                                                    .map(
                                                        role -> new SimpleGrantedAuthority("ROLE_" + role) 
                                                    )
                                                    .toList();

        return roleList;

    }


}
