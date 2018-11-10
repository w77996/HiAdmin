package com.w77996.admin.controller;

import com.github.pagehelper.PageInfo;
import com.w77996.admin.core.exception.ServiceException;
import com.w77996.admin.core.ret.RetResponse;
import com.w77996.admin.core.ret.RetResult;
import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户web
 * @author: w77996
 * @create: 2018-11-08 12:58
 **/
@RestController
@RequestMapping("userInfo")
@Api(tags = {"用户操作接口"}, description = "userInfoControler")
@Slf4j
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/hello")
    public String hello() {
        return "hello SpringBoot";
    }

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true,
                    dataType = "Integer", paramType = "query")
    })
    @GetMapping("/selectById")
    public RetResult<UserInfo> selectById(@RequestParam String id) {
        log.info("enter selectById");
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }

    @PostMapping("/testException")
    public RetResult<UserInfo> testException(String id) {
        List a = null;
        a.size();
        UserInfo userInfo = userInfoService.selectById(id);
        return RetResponse.makeOKRsp(userInfo);
    }


    @ApiOperation(value = "查询用户", notes = "分页查询用户所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码",
                    dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示条数",
                    dataType = "Integer", paramType = "query")
    })
    @PostMapping("/selectAll")
    public RetResult<PageInfo<UserInfo>> selectAll(@RequestParam(defaultValue = "0") Integer page,
                                                   @RequestParam(defaultValue = "0") Integer size) {
        PageInfo<UserInfo> pageInfo = userInfoService.selectAll(page, size);
        return RetResponse.makeOKRsp(pageInfo);
    }

    @PostMapping("/login")
    public RetResult<UserInfo> login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        //登录
        try {
            currentUser.login(new UsernamePasswordToken(userName, password));
        }catch (IncorrectCredentialsException i){
            throw new ServiceException("密码输入错误");
        }
        //从session取出用户信息
        UserInfo user = (UserInfo) currentUser.getPrincipal();
        return RetResponse.makeOKRsp(user);
    }


}