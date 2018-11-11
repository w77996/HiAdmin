package com.w77996.admin.service.impl;

import com.w77996.admin.dao.RolePermMapper;
import com.w77996.admin.model.RolePerm;
import com.w77996.admin.service.RolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class RolePermServiceImpl implements RolePermService {

    @Autowired
    private RolePermMapper rolePermMapper;

    @Override
    public List<String> getPermsByUserId(String id) {
        return rolePermMapper.getPermsByUserId(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(RolePerm record) {
        return 0;
    }

    @Override
    public int insertSelective(RolePerm record) {
        return 0;
    }

    @Override
    public RolePerm selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(RolePerm record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(RolePerm record) {
        return 0;
    }

    @Override
    public List<RolePerm> selectAll() {
        return null;
    }
}
