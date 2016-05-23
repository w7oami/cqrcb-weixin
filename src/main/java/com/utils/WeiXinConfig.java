package com.utils;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import javax.net.ssl.SSLContext;
import java.io.File;

/**
 * Created by Administrator on 2016/5/23.
 */
public class WeiXinConfig {

    public static WxMpInMemoryConfigStorage config;

    //单利的WxCpServiceImpl
    private static WxMpServiceImpl wxMpService;

    //微信appID
    public static final String AppID = PropUtils.getProperty("weixin.appID");

    public static final String Secret = PropUtils.getProperty("weixin.secret");

    public static final String Token = PropUtils.getProperty("weixin.token");

    public static final String AesKey = PropUtils.getProperty("weixin.aesKey");

    static {
        config = new WxMpInMemoryConfigStorage();
        config.setAppId(AppID);
        config.setSecret(Secret);
        config.setToken(Token);
        config.setAesKey(AesKey);
    }

    /**
     * 单利获取service
     * @return
     * @throws Exception
     */
    public static WxMpService getWxMpService() throws Exception{
        if(null == wxMpService) {
            wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(config);
        } else {
            System.out.println(wxMpService.getAccessToken());
        }
        return wxMpService;
    }

    public static void main(String [] args) throws Exception {
        String url = WeiXinConfig.getWxMpService().oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_BASE, "http://zhouji.ittun.com/cqrcb/active");
        System.out.println(url);
    }
}
