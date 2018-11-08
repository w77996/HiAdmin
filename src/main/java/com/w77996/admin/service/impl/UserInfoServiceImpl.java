package com.w77996.admin.service.impl;

import com.w77996.admin.dao.UserInfoMapper;
import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: w77996
 * @create: 2018-11-08 13:01
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo selectById(Integer id){
        return userInfoMapper.selectById(id);
    }
}
