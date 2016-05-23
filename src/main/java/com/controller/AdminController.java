package com.controller;

import com.alibaba.fastjson.JSON;
import com.dao.util.Condition;
import com.dao.util.SearchOperator;
import com.dao.util.Searchable;
import com.github.pagehelper.PageInfo;
import com.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台管理员Controller
 */
@Controller
public class AdminController extends BaseController {

	/**
	 * 查询用户账户信息
	 * @return
     */
	@RequestMapping(value = "/admin/cardInfo/list")
	public String cardInfoList() {
		return "/admin/cardInfoList";
	}
}
