//package com.example.hrteamproject.Configure;
//
//import com.example.hrteamproject.Security.filter.JwtFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//@Configuration
//public class FileConfig {
//
//    @Value("${services.auth}")
//    private String authService;
//
//    @CrossOrigin
//    @Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilter() {
//        Map<String, String> map = new HashMap<>();
//        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//        map.put("exclusions", "/register");
//        map.put("services.auth", authService);
//        registrationBean.setFilter(new JwtFilter());
//        registrationBean.setInitParameters(map);
////        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }
////    @Bean
////    public JavaMailSender getJavaMailSender() {
////        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
////        mailSender.setHost("smtp.gmail.com");
////        mailSender.setPort(587);
//}
