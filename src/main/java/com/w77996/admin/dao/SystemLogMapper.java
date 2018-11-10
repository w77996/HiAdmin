package com.w77996.admin.dao;


import com.w77996.admin.model.SystemLog;

import java.util.List;

public interface SystemLogMapper  {

    Integer insertByBatch(List<SystemLog> list);
}