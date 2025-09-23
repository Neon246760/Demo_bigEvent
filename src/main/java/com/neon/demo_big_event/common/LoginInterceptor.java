package com.neon.demo_big_event.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                String token = request.getHeader("Authorization");
                try {
                    JwtUtil.parseToken(token);
                    return true;
                } catch (Exception e) {
                    response.setStatus(401);
                    return false;
                }
    }
}
