package com.w77996.admin.service;

import com.w77996.admin.model.SysRole;

import java.util.List;

public interface SysRoleService {

    int deleteByPrimaryKey(String id);


    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> selectAll();
}
