package com.w77996.admin.service;


import com.w77996.admin.model.SysPermissionInit;

import java.util.List;

/**
* @Description: SysPermissionInitService接口
* @author 张瑶
* @date 2018/05/18 14:37
*/
public interface SysPermissionInitService {

    List<SysPermissionInit> selectAllOrderBySort();

}