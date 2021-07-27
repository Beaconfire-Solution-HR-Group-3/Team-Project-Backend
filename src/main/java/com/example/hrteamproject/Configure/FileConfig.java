package com.example.hrteamproject.Configure;

import com.example.hrteamproject.Security.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//@Configuration
public class FileConfig {

    @Value("${services.auth}")
    private String authService;



    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter(){
        Map<String,String> map = new HashMap<>();
        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        map.put("exclusions", "/register,/token,/druid/*");
        map.put("services.auth", authService);
        registrationBean.setFilter(new JwtFilter());
        registrationBean.setInitParameters(map);
//        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
//    @Bean
//    public JavaMailSender getJavaMailSender() {
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//
//        mailSender.setUsername("my.gmail@gmail.com");
//        mailSender.setPassword("password");
//
//        Properties props = mailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//
//        return mailSender;
//    }
}
