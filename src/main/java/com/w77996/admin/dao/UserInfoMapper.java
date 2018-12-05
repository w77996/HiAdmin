package com.w77996.admin.dao;

import com.w77996.admin.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description:
 * @author: w77996
 * @create: 2018-11-08 13:01
 **/
public interface UserInfoMapper extends Mapper<UserInfo> {

    UserInfo selectById(@Param("id") String id);

    List<UserInfo> selectAll();

    UserInfo selectUserInfoByUsername(@Param("username") String username);
}
