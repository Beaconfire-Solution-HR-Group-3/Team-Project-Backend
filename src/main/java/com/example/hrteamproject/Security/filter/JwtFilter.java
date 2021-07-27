package com.example.hrteamproject.Security.filter;


import com.example.hrteamproject.Constant.Constant;
import com.example.hrteamproject.Security.Util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(JwtFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String username = JwtUtil.getSubject(httpServletRequest, Constant.JWT_TOKEN_COOKIE_NAME, Constant.SIGNING_KEY);
        // httpServletRequest.getRequestURL()
        log.info("dofilter");
        String excludes = this.getFilterConfig().getInitParameter("exclusions");
        if (username == null){
            String authService = this.getFilterConfig().getInitParameter("services.auth");
            log.info(authService);
            httpServletResponse.sendRedirect(authService);

        } else {
            httpServletRequest.setAttribute("username", username);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}