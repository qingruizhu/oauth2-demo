package com.dove.cloud.auth.custom;//package com.dove.common.oauth2.component;

import com.common.dove.oauth2.base.principal.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: qingruizhu
 * @Date: 2020/8/12 09:47
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException("the user:" + username + " is not found");
        }
        return new OauthUser(1L, "123456", "17346578001", username, passwordEncoder.encode("123456"), Arrays.asList(new SimpleGrantedAuthority("admin")));
    }
}
