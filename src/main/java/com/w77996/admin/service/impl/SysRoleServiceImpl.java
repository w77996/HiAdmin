package com.w77996.admin.service.impl;

import com.w77996.admin.dao.SysRoleMapper;
import com.w77996.admin.model.SysPerm;
import com.w77996.admin.model.SysRole;
import com.w77996.admin.service.SysPermService;
import com.w77996.admin.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(String id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRole> selectAll() {
        return sysRoleMapper.selectAll();
    }
}
