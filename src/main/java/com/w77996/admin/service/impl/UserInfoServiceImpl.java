package com.w77996.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.w77996.admin.dao.UserInfoMapper;
import com.w77996.admin.model.UserInfo;
import com.w77996.admin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: w77996
 * @create: 2018-11-08 13:01
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo selectById(String id){
        return userInfoMapper.selectById(id);
    }

    @Override
    public PageInfo<UserInfo> selectAll(Integer page, Integer size) {
        //开启分页查询，写在查询语句上方
        //只有紧跟在PageHelper.startPage方法后的第一个Mybatis的查询（Select）方法会被分页。
        PageHelper.startPage(page, size);
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
        return pageInfo;
    }

    @Override
    public UserInfo selectUserInfoByUsername(String username) {
        return userInfoMapper.selectUserInfoByUsername(username);
    }

}
