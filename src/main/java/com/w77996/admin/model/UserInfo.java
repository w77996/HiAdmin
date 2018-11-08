package com.w77996.admin.model;

import lombok.Data;

/**
 * @description:
 * @author: w77996
 * @create: 2018-11-08 13:02
 **/
@Data
public class UserInfo {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    private String password;


}
