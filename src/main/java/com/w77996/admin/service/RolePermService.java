package com.w77996.admin.service;

import java.util.List;

public interface RolePermService {
    /**
     * 根据userId获取权限
     * @param id
     * @return
     */
    List<String> getPermsByUserId(String id);
}
