package com.example.hrteamproject.Security.filter;


import com.example.hrteamproject.Constant.Constant;
import com.example.hrteamproject.Security.Util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin
@Component
public class JwtFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(JwtFilter.class);

    @CrossOrigin
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String username = JwtUtil.getSubject(httpServletRequest, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        log.info("dofilter");
        String url = httpServletRequest.getRequestURI();
        if (username == null && !url.equals("/") && !url.equals("/register") && !url.startsWith("/notLoginHandler")){
            String authService = this.getFilterConfig().getInitParameter("services.auth");
            httpServletResponse.sendRedirect( "/notLoginHandler"+"?redirect=" + httpServletRequest.getRequestURL());
        } else {
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}

