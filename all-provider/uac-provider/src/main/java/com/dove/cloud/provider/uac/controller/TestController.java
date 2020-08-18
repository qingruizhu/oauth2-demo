package com.dove.cloud.provider.uac.controller;

import com.common.dove.oauth2.base.OauthUserHolder;
import com.common.dove.oauth2.base.principal.OauthUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/12 11:05
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public Object a() {
        return "aaaa";
    }

    @GetMapping("/hh")
    public Object hhh() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();
        Object details = authentication.getDetails();
        OAuth2AuthenticationDetails authDetails = (OAuth2AuthenticationDetails) details;
        String tokenValue = authDetails.getTokenValue();

        String claims = JwtHelper.decode(tokenValue).getClaims();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map map = objectMapper.readValue(claims, Map.class);
            System.out.println(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        OauthUser user = OauthUserHolder.user();
        System.out.println(user);
        return authentication;
    }

    @GetMapping("/aa")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object aa(Authentication authentication) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }

}
