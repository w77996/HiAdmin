package com.w77996.admin.dao;


import com.w77996.admin.model.SysPerm;

import java.util.List;

public interface SysPermMapper {

    int deleteByPrimaryKey(String id);

    int insert(SysPerm record);

    int insertSelective(SysPerm record);

    SysPerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPerm record);

    int updateByPrimaryKey(SysPerm record);

    List<SysPerm> selectAll();
}