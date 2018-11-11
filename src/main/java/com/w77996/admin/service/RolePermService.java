package com.w77996.admin.service;

import com.w77996.admin.model.RolePerm;

import java.util.List;

public interface RolePermService {
    /**
     * 根据userId获取权限
     * @param id
     * @return
     */
    List<String> getPermsByUserId(String id);

    int deleteByPrimaryKey(String id);

    int insert(RolePerm record);

    int insertSelective(RolePerm record);

    RolePerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePerm record);

    int updateByPrimaryKey(RolePerm record);

    List<RolePerm> selectAll();
}
