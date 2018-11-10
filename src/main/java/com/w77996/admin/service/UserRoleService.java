package com.w77996.admin.service;

import java.util.List;

public interface UserRoleService {
    /**
     * 根据userId获取角色
     * @param id
     * @return
     */
    List<String> getRolesByUserId(String id);
}
