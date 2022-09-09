package com.example.demo.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.jwt.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.sendRedirect("/login");
            return false;
        }
        Map<String, Claim> user = JwtUtil.verifyToken(token);
        if (user == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
