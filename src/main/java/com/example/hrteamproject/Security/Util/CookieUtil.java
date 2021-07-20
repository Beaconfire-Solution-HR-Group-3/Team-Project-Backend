package com.example.hrteamproject.Security.Util;


import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {
    public static String getValue(HttpServletRequest httpServletRequest, String cookieName){
        Cookie cookie = WebUtils.getCookie(httpServletRequest, cookieName);
        return cookie != null ? cookie.getValue() : null;
    }
}
