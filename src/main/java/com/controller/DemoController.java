package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

/**
 * Created by Administrator on 2015/12/10.
 */
@Controller
public class DemoController {
    @RequestMapping(value = "demo")
    public String demo(){
        return "demo/payDemo";
    }

    @RequestMapping(value = "excel")
    public String excel() throws Exception {
        File file=new File("D:/桌面/渝台发标张.doc");


        return "demo/excelDemo";
    }


}
