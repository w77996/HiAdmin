package com.w77996.admin.dao;



import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserRoleMapper {

    List<String> getRolesByUserId(@Param("userId") String userId);
}