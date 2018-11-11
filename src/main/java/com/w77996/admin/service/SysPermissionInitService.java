package com.w77996.admin.service;


import com.w77996.admin.model.SysPermissionInit;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
*/
public interface SysPermissionInitService {

    List<SysPermissionInit> selectAllOrderBySort();

}