package com.w77996.admin.service.impl;

import com.w77996.admin.dao.SysPermissionInitMapper;
import com.w77996.admin.model.SysPermissionInit;
import com.w77996.admin.service.SysPermissionInitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermissionInitService接口实现类
* @author 张瑶
* @date 2018/05/18 14:37
*/
@Service
public class SysPermissionInitServiceImpl  implements SysPermissionInitService {

    @Resource
    private SysPermissionInitMapper sysPermissionInitMapper;

    @Override
    public List<SysPermissionInit> selectAllOrderBySort(){
        return sysPermissionInitMapper.selectAllOrderBySort();
    }

}