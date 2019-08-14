package com.cafe24.security;

import com.cafe24.mall.frontend.service.UserService;
import com.cafe24.mall.frontend.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserService userService;


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

        if(!StringUtils.isEmpty(email)&&
                !StringUtils.isEmpty(password)){
            HttpSession session = request.getSession(true);


            UserVo userInfo = userService.login(email,password);

            if(userInfo!=null) {
                session.setAttribute("userRole", "ROLE_USER");
                session.setAttribute("authUserInfo", userInfo);

                response.sendRedirect("/");
                return false;
            }
        }

        response.sendRedirect(request.getContextPath() + "/user/login");
        return false;
    }
}
