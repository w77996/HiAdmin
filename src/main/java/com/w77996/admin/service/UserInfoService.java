package com.w77996.admin.service;

import com.github.pagehelper.PageInfo;
import com.w77996.admin.model.UserInfo;

/**
 * @description: usre接口
 * @author: w77996
 * @create: 2018-11-08 13:00
 **/
public interface UserInfoService {

    UserInfo selectById(String id);

    PageInfo<UserInfo> selectAll(Integer page, Integer size);
}
