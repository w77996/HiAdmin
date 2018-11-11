package com.w77996.admin.service;


import com.w77996.admin.model.SysPerm;

import java.util.List;

/**
* @Description: SysPermService接口
*/
public interface SysPermService {

    int deleteByPrimaryKey(String id);


    int insertSelective(SysPerm record);

    SysPerm selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPerm record);

    int updateByPrimaryKey(SysPerm record);

    List<SysPerm> selectAll();
}