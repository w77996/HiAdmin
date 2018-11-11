package com.w77996.admin.service.impl;

import com.w77996.admin.dao.SysPermMapper;
import com.w77996.admin.model.SysPerm;
import com.w77996.admin.service.SysPermService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermService接口实现类
*/
@Service
public class SysPermServiceImpl  implements SysPermService {

    @Resource
    private SysPermMapper sysPermMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return sysPermMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertSelective(SysPerm record) {
        return sysPermMapper.insertSelective(record);
    }

    @Override
    public SysPerm selectByPrimaryKey(String id) {
        return sysPermMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysPerm record) {
        return sysPermMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysPerm record) {
        return sysPermMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysPerm> selectAll() {
        return sysPermMapper.selectAll();
    }
}