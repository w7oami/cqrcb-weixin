package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/23.
 */
public class CqrcbController extends BaseController {

    @RequestMapping(value = "/cqrcb/active")
    public String activeInit(@RequestParam(value = "code") String code,
                             @RequestParam(value = "state") String state,
                             HttpServletRequest request) {
        return "";
    }
}
