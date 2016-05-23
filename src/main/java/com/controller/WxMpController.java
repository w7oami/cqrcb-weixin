package com.controller;

import com.service.WxService;
import com.utils.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/5/23.
 */
@Controller
public class WxMpController extends BaseController {

    @Autowired
    private WxService wxService;

    /**
     * 微信地址验证
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @param response
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void init(String signature, String timestamp, String nonce,String echostr, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String text = wxService.weChatAccess(signature, timestamp, nonce, echostr);
            out.print(text);
        } catch (Exception e) {
            Logger.info(e);
        } finally {
            out.close();
            out = null;
        }
    }
}
