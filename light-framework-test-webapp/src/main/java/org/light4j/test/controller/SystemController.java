package org.light4j.test.controller;

import org.light4j.framework.annotation.Action;
import org.light4j.framework.annotation.Controller;
import org.light4j.framework.bean.Param;
import org.light4j.framework.bean.View;
import org.light4j.plugin.sercurity.SecurityHelper;
import org.light4j.plugin.sercurity.exception.AuthcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理系统请求
 * Created by weimiantong on 18/10/26.
 */
@Controller
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    /**
     * 进入首界面
     */
    @Action("get:/")
    public View index() {
        return new View("index.jsp");
    }

    /**
     * 进入登录界面
     */
    @Action("get:/login")
    public View login() {
        return new View("login.jsp");
    }

    /**
     * 提交登录表单
     */
    @Action("post:/login")
    public View loginSubmit(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");
        try {
            SecurityHelper.login(username, password);
        } catch (AuthcException e) {
            LOGGER.error("login failure", e);
            return new View("/login");
        }
        return new View("/customer");
    }

    /**
     * 提交注销请求
     */
    @Action("get:/logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("/");
    }
}
