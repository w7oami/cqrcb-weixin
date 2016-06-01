package com.controller;

import com.google.gson.Gson;
import com.model.GUser;
import com.service.GameUserService;
import com.service.WxService;
import com.utils.PropUtils;
import com.utils.WeiXinConfig;
import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/23.
 */
@Controller
public class CqrcbController extends BaseController {

    @Autowired
    private WxService wxService;

    @Autowired
    private GameUserService gameUserService;

    /**
     * 首页
     * @param code
     * @param state
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cqrcb/active")
    public String activeInit(@RequestParam(value = "code") String code,
                             @RequestParam(value = "state") String state,
                             HttpServletRequest request) throws Exception {
        String openId = (String)request.getAttribute("openid");
        GUser user = gameUserService.getUserByWX(openId);
        boolean isAuth = wxService.authOpenId(openId);
        request.setAttribute("isAuth", isAuth);
        request.setAttribute("isHas", null != user);
        return "mobile/index";
    }

    /**
     * 验证用户是否关注
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cqrcb/authOpenId")
    @ResponseBody
    public String authOpenId(HttpServletRequest request) throws Exception {
        String openId = (String)request.getAttribute("openid");
        boolean isAuth = wxService.authOpenId(openId);

        return "{isAuth : " + isAuth + "}";
    }

    /**
     * 跳转
     * @param url
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/cqrcb/redirect/{url}")
    public String redirectUrl(@PathVariable(value = "url") String url) throws Exception {
        url = PropUtils.getProperty("weixin." + url);
        String redirect = WeiXinConfig.getWxMpService().oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, null);
        return "redirect:" + redirect;
    }

    /**
     * 开始游戏准备界面
     * @param request
     * @return
     */
    @RequestMapping(value = "/cqrcb/gameView")
    public String gameView(HttpServletRequest request) {
        String openId = (String)request.getAttribute("openid");
        int count = gameUserService.getUserGameNumber(openId);
        request.setAttribute("gameCount", count);
        return "mobile/gameStart";
    }

    /**
     * 保存用户信息
     * @param name
     * @param phone
     * @param request
     * @return
     */
    @RequestMapping(value = "/cqrcb/saveUser")
    @ResponseBody
    public String insertGameUser(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "phone") String phone,
                                 HttpServletRequest request) {
        String openId = (String)request.getAttribute("openid");
        GUser user = gameUserService.getUserByWX(openId);
        if(null != user) {
            return "userMore";
        }

        int count = gameUserService.countUserByPhone(phone);
        if(count > 0) {
            return "phoneMore";
        }
        user = new GUser();
        user.setName(name);
        user.setWxid(openId);
        user.setPhone(phone);
        user.setPoint(0l);
        user.setCreateTime(new Date());
        gameUserService.saveGameUser(user);
        return "ok";
    }

    /**
     * 游戏界面
     * @param request
     * @return
     */
    @RequestMapping(value = "/cqrcb/game")
    public String game(HttpServletRequest request) {
        String openId = (String)request.getAttribute("openid");
        return "mobile/game";
    }

    /**
     * 获取当次分数集合
     * @param request
     * @return
     */
    @RequestMapping(value = "/cqrcb/getRandomPoint")
    @ResponseBody
    public String getRandomPoint(HttpServletRequest request) {
        String openId = (String)request.getAttribute("openid");
        List<Map<String, Object>> list = gameUserService.getRandomPoint(openId);

        return new Gson().toJson(list);
    }

    @RequestMapping(value = "/cqrcb/fail")
    public String redirectFail() {
        return "mobile/fail";
    }
}
