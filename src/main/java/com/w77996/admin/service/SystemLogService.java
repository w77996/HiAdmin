package com.w77996.admin.service;


import com.w77996.admin.model.SystemLog;

import java.util.List;

/**
* @Description: SystemLogService接口
* @author 张瑶
* @date 2018/04/25 15:52
*/
public interface SystemLogService {

    Integer insertByBatch(List<SystemLog> list);

}