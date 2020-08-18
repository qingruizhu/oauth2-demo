package com.dove.cloud.provider.client2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/12 11:05
 */
@RestController
public class TestController {

    @GetMapping("/test")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Object test(Authentication authentication) {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        String token = details.getTokenValue();
        return token;
    }


}
