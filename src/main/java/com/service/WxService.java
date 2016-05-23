package com.service;

import com.utils.HttpUtils;
import com.utils.Logger;
import com.utils.WeiXinConfig;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.util.crypto.WxMpCryptUtil;
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

    public String getHTMLAcceccToken(String code) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeiXinConfig.AppID + "&secret=" + WeiXinConfig.Secret + "&code=" + code + "&grant_type=authorization_code";
        map = HttpUtils.get2Map(url);
        System.out.println(map.toString());
        return map.get("access_token");
    }

    public String refreshHTMLToken(String accessToken) {
        return null;
    }
}
