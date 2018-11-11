package com.w77996.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.w77996.admin.core.ret.RetResponse;
import com.w77996.admin.core.ret.RetResult;
import com.w77996.admin.core.utils.ApplicationUtils;
import com.w77996.admin.model.SysPerm;
import com.w77996.admin.service.SysPermService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* @Description: SysPermController类
* @author 张瑶
* @date 2018/05/26 00:30
*/
@RestController
@RequestMapping("/sysPerm")
public class SysPermController {

    @Resource
    private SysPermService sysPermService;

    @PostMapping("/insert")
    public RetResult<Integer> insert(SysPerm sysPerm) throws Exception{
		sysPerm.setId(ApplicationUtils.getUUID());
    	Integer state = sysPermService.insertSelective(sysPerm);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/deleteById")
    public RetResult<Integer> deleteById(@RequestParam String id) throws Exception {
        Integer state = sysPermService.deleteByPrimaryKey(id);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/update")
    public RetResult<Integer> update(SysPerm sysPerm) throws Exception {
        Integer state = sysPermService.updateByPrimaryKeySelective(sysPerm);
        return RetResponse.makeOKRsp(state);
    }

    @PostMapping("/selectById")
    public RetResult<SysPerm> selectById(@RequestParam String id) throws Exception {
        SysPerm sysPerm = sysPermService.selectByPrimaryKey(id);
        return RetResponse.makeOKRsp(sysPerm);
    }

    /**
	* @Description: 分页查询
	* @param page 页码
	* @param size 每页条数
	* @Reutrn RetResult<PageInfo<SysPerm>>
	*/
    @PostMapping("/list")
    public RetResult<PageInfo<SysPerm>> list(@RequestParam(defaultValue = "0") Integer page,
					@RequestParam(defaultValue = "0") Integer size) throws Exception {
        PageHelper.startPage(page, size);
        List<SysPerm> list = sysPermService.selectAll();
        PageInfo<SysPerm> pageInfo = new PageInfo<SysPerm>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
}