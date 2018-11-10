package com.w77996.admin.service.impl;

import com.w77996.admin.dao.UserRoleMapper;
import com.w77996.admin.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<String> getRolesByUserId(String id) {
        return userRoleMapper.getRolesByUserId(id);
    }
}
