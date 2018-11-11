package com.w77996.admin.controller;

import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shiroUtils")
public class ShiroUtilsController {

    @Autowired
    private ShiroService shiroService;

    @GetMapping("/noLogin")
    public void noLogin() {
        throw new UnauthenticatedException();
    }

    @GetMapping("/noAuthorize")
    public void noAuthorize() {
        throw new UnauthorizedException();
    }


    @PostMapping("/getNowUser")
    public UserInfo getNowUser() {
        UserInfo u = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return u;
    }

    /**
     * @Description: 重新加载shiro权限
     * @throws Exception
     */
    @PostMapping("/updatePermission")
    public void updatePermission() throws Exception {
        shiroService.updatePermission();
    }



}