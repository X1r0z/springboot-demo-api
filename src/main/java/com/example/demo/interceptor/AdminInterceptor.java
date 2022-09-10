package com.example.demo.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.example.demo.jwt.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        Map<String, Claim> user = JwtUtil.verifyToken(token);
        int isAdmin = user.get("isAdmin").asInt();
        if (isAdmin == 1){
            return true;
        } else {
            PrintWriter pw = response.getWriter();
            pw.write("{\"code\":-1, \"message\":\"permission denied\", \"data\":null}");
            pw.flush();
            return false;
        }
    }
}
