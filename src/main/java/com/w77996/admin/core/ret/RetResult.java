package com.w77996.admin.core.ret;

import lombok.Data;

/**
 * @description: 返回对象实体
 * @author: w77996
 * @create: 2018-11-08 17:42
 **/
@Data
public class RetResult<T> {
    public int code;

    private String msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.code;
        return this;
    }

    public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }


}
