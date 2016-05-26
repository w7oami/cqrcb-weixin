package com.annotation.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.WxService;
import com.utils.CookiesUtils;
import com.utils.Logger;
import com.utils.PropUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.annotation.model.UserRole;

import java.util.Map;

public class UserAuthHandlerInterceptorAdapter extends HandlerInterceptorAdapter {

    @Autowired
    WxService wxService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
        boolean isWX = false;
        String openid = null;
        if(request.getServletPath().indexOf("/static") == 0) {
            return true;
        }

        if(request.getServletPath().indexOf(".jsp") > 0) {
            return true;
        }

        openid = CookiesUtils.getCookieValue(request, "mobile_user");
        if(null != openid) {
            isWX = true;
        }

        if(null != request.getParameter("code") && null != request.getParameter("state")) {
            openid = wxService.getHTMLOpenID(openid, request.getParameter("code"));
            System.out.println(openid);
            isWX = true;
        }

        if(isWX) {
            CookiesUtils.setCookie(request, response, "mobile_user", openid);
            String url = PropUtils.getProperty("weixin.url");
            String params = request.getQueryString();
            if(null != params) {
                url += request.getServletPath() + "?" + params;
            } else {
                url += request.getServletPath();
            }
            Logger.debug("request请求完整地址：" + url);
            Map<String, Object> jsMap = wxService.getJsApiConfig(url);
            request.setAttribute("openid", openid);
            request.setAttribute("jsApiConfig", jsMap);
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
