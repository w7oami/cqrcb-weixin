package com.controller;

import com.model.GUser;
import com.service.GameUserService;
import com.service.WxService;
import com.utils.PropUtils;
import com.utils.WeiXinConfig;
import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/23.
 */
@Controller
public class CqrcbController extends BaseController {

    @Autowired
    private WxService wxService;

    @Autowired
    private GameUserService gameUserService;

    @RequestMapping(value = "/cqrcb/active")
    public String activeInit(@RequestParam(value = "code") String code,
                             @RequestParam(value = "state") String state,
                             HttpServletRequest request) {
        String openId = (String)request.getAttribute("openid");
        GUser user = gameUserService.getUserByWX(openId);
        request.setAttribute("toUrl", "/cqrcb/redirect/game");
        return "mobile/success";
    }

    @RequestMapping(value = "/cqrcb/authOpenId")
    public String authOpenId(HttpServletRequest request) throws Exception {
        String openId = (String)request.getAttribute("openid");
        boolean isAuth = wxService.authOpenId(openId);
        return null;
    }

    @RequestMapping(value = "/cqrcb/redirect/{url}")
    public String redirectUrl(@PathVariable(value = "url") String url) throws Exception {
        url = PropUtils.getProperty("weixin." + url);
        String redirect = WeiXinConfig.getWxMpService().oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, null);
        return "redirect:" + redirect;
    }

    @RequestMapping(value = "/cqrcb/gameView")
    public String gameView(HttpServletRequest request) {
        return "mobile/fail";
    }
}
