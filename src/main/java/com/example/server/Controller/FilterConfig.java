//package com.example.server.Controller;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean registFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new NoCachesFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("NoCachesFilter");
//        registration.setOrder(1);
//        return registration;
//    }
//}
