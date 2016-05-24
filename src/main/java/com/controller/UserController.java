package com.controller;

import com.annotation.model.UserRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/5/24.
 */
@Controller
public class UserController extends BaseController {

    @RequestMapping(value = "/admin/userListView")
    @UserRole
    public String userListView() {
        return "admin/user/userList";
    }
}
