package com.example.demo.privacy;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Component
public abstract class AuthPrivacy extends OncePerRequestFilter {
    @Autowired
    private ServicePrivacy ServicePrivacy;

    @Autowired
    private UserDetailsService userDetailsService;

    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (StringUtils.hasText(authHeader) && authHeader.startsWith("init")) {
            return authHeader.substring(10);
        }
        return null;
    }

}