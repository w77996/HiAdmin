package com.w77996.admin.dao;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermMapper  {

    List<String> getPermsByUserId(@Param("userId") String userId);
}