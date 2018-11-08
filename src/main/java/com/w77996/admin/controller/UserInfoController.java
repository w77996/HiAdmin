package com.w77996.admin.controller;

import com.w77996.admin.core.ret.RetResponse;
import com.w77996.admin.core.ret.RetResult;
import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 用户web
 * @author: w77996
 * @create: 2018-11-08 12:58
 **/
@RestController
@RequestMapping("userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }

    @PostMapping("/selectById")
    public RetResult<UserInfo> selectById(Integer id){
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }




}
