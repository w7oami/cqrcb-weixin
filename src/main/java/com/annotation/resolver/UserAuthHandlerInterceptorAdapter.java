package com.annotation.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.annotation.model.UserRole;

public class UserAuthHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
        boolean isWX = false;

        if(request.getServletPath().indexOf("/static") == 0) {
            return true;
        }

        if(request.getServletPath().indexOf(".jsp") > 0) {
            return true;
        }

        if(null != request.getParameter("code") && null != request.getParameter("state")) {
            String servletPath = request.getServletPath().substring(1, request.getServletPath().length());
            Logger.debug("servlet地址：" + servletPath);
            if(null == suiteId || (null != suiteTemp && !suiteId.equals(suiteTemp))) {
                suiteId = suiteTemp;

            }
            if(null == userID || "null".equals(userID)) {
                userID = weChatService.oauth2getUserInfo(corpId, suiteId, request.getParameter("code"));
            }

            isWX = true;
        }

		if(handler.getClass().isAssignableFrom(HandlerMethod.class)){
			UserRole userRole = ((HandlerMethod) handler).getMethodAnnotation(UserRole.class);
            
            //没有声明需要权限,或者声明不验证权限
            if(userRole == null || userRole.validate() == false) {
                return true;
            } else {
                Object obj = request.getSession().getAttribute("token");
                if(null == obj) {
                    response.sendRedirect("/admin/login");
                    return false;
                } else {
                    return true;
                }
            }
        }
        else
            return true;
	}
}
