package com.w77996.admin.dao;

import com.w77996.admin.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: w77996
 * @create: 2018-11-08 13:01
 **/
public interface UserInfoMapper {

    UserInfo selectById(@Param("id") Integer id);
}
