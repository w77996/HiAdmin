package com.w77996.admin.service.impl;

import com.w77996.admin.dao.SystemLogMapper;
import com.w77996.admin.model.SystemLog;
import com.w77996.admin.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SystemLogService接口实现类
*/
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogMapper systemLogMapper;

    @Override
    public Integer insertByBatch(List<SystemLog> list) {
        return systemLogMapper.insertByBatch(list);
    }
}