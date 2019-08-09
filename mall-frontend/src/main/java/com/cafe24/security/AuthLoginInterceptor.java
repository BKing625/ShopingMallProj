package com.cafe24.security;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if("admin@admin.kr".equals(email)
        && "admin".equals(password))
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("userRole", "ROLE_ADMIN");
            response.sendRedirect("/");
            return false;
        }

        response.sendRedirect(request.getContextPath() + "/user/login");
        return false;
    }
}
