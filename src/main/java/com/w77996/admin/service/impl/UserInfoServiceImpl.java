package com.w77996.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.w77996.admin.core.exception.ServiceException;
import com.w77996.admin.core.universal.AbstractService;
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
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService{

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo selectById(String id){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        if(userInfo == null){
            throw new ServiceException("暂无该用户");
        }
        return userInfo;
    }


}
