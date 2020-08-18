//package com.dove.cloud.provider.uac.config;
//
///**
// * 在 OAuth2 的概念里，所有的接口都被称为资源，接口的权限也就是资源的权限，
// * 所以 Spring Security OAuth2 中提供了关于资源的注解 @EnableResourceServer，
// * 和 @EnableWebSecurity的作用类似。
// */
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @Description:资源配置文件
// * @Auther: qingruizhu
// * @Date: 2020/8/12 10:59
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .headers().frameOptions().disable()
//                .and()
//                .csrf().disable()
//                .exceptionHandling()
//                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .authorizeRequests().antMatchers("/test/**","/druid/**", "/pay/alipayCallback", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/api/applications").permitAll()
//                .anyRequest().authenticated();
//    }
//}