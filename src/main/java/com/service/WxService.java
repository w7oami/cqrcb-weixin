package com.service;

import com.utils.HttpUtils;
import com.utils.Logger;
import com.utils.WeiXinConfig;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.util.crypto.WxMpCryptUtil;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/23.
 */
@Service
public class WxService extends BaseService {

    protected WxMpService wxMpService;

    /**
     * 微信签名认证/审核
     * @param signature 微信加密签名、结合了企业填写的token、请求中的timestamp、nonce参数、加密的消息体
     * @param timestamp 时间戳
     * @param nonce 随机数
     * @param echostr 加密的随机字符串,需要解密并返回echostr明文，解密后有random、msg_len、msg、$CorpID四个字段，其中msg即为echostr明文
     * @return String
     */
    public String weChatAccess(String signature, String timestamp, String nonce, String echostr){
        //返回值
        String result = "error";
        try {
            wxMpService = WeiXinConfig.getWxMpService();
            if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
                // 消息签名不正确，说明不是公众平台发过来的消息
                return "非法请求";
            }

            if (StringUtils.isNotBlank(echostr)) {
                // 说明是一个仅仅用来验证的请求，回显echostr
                return echostr;
            }

        } catch (Exception e) {
            Logger.info(e);
        }
        return result;
    }

    /**
     * 获取OpenId
     * @param openid
     * @param code
     * @return
     * @throws Exception
     */
    public String getHTMLOpenID(String openid, String code) throws Exception {
        wxMpService = WeiXinConfig.getWxMpService();
        Cache cache = cacheManager.getCache("ehcache_3600s");
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        Element el = null;
        if(null != openid) {
            el = cache.get(openid);
            if(null == el) {
                wxMpOAuth2AccessToken = (WxMpOAuth2AccessToken) el.getObjectValue();
            }
            if (null == wxMpOAuth2AccessToken) {
                wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
                el = new Element(wxMpOAuth2AccessToken.getOpenId(), wxMpOAuth2AccessToken);
                cache.put(el);
            } else {
                //验证token是否正确
                boolean valid = wxMpService.oauth2validateAccessToken(wxMpOAuth2AccessToken);
                if (!valid) { //不正确就刷新token
                    wxMpOAuth2AccessToken = wxMpService.oauth2refreshAccessToken(wxMpOAuth2AccessToken.getRefreshToken());
                }
            }
        } else {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            el = new Element(wxMpOAuth2AccessToken.getOpenId(), wxMpOAuth2AccessToken);
            cache.put(el);
        }
        return wxMpOAuth2AccessToken.getOpenId();
    }

    /**
     * 获取jsskd参数
     * @param url
     * @return
     * @throws Exception
     */
    public Map<String, Object> getJsApiConfig(String url) throws Exception {
        wxMpService = WeiXinConfig.getWxMpService();
        WxJsapiSignature wxJsapiSignature = wxMpService.createJsapiSignature(url);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("appId", wxJsapiSignature.getAppid());
        map.put("timestamp", wxJsapiSignature.getTimestamp());
        map.put("nonceStr", wxJsapiSignature.getNoncestr());
        map.put("signature", wxJsapiSignature.getTimestamp());
        return map;
    }

    /**
     * 生成授权跳转链接
     * @param redirect_uri
     * @return
     */
    public String oauth2buildAuthorizationUrl(String redirect_uri) throws Exception {
        wxMpService = WeiXinConfig.getWxMpService();
        String url = wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_BASE, redirect_uri);
        return url;
    }
}
