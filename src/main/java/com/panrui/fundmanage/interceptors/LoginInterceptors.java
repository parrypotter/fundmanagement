package com.panrui.fundmanage.interceptors;

import com.panrui.fundmanage.domain.Admin;
import com.panrui.fundmanage.domain.User;
import com.panrui.fundmanage.util.Const;
import com.panrui.fundmanage.util.IsObjectEmpty;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        IsObjectEmpty isObjectEmpty = new IsObjectEmpty();
        Admin admin =(Admin) request.getSession().getAttribute(Const.ADMIN);
        User user = (User) request.getSession().getAttribute(Const.USER);
        if(!isObjectEmpty.isEmpty(admin)||!isObjectEmpty.isEmpty(user)){
            return true;
        }
        response.sendRedirect(request.getContextPath()+"/system/login");
        return false;
    }


}
