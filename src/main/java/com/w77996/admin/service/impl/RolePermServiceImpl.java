package com.w77996.admin.service.impl;

import com.w77996.admin.dao.RolePermMapper;
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
}
