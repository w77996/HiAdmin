package com.w77996.admin.dao;


import com.w77996.admin.model.SysPermissionInit;

import java.util.List;

public interface SysPermissionInitMapper {

    List<SysPermissionInit> selectAllOrderBySort();
}