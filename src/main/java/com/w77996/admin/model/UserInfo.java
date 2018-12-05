package com.w77996.admin.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

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
    @Id
    private String id;

    /**
     * 用户名
     */
    private String userName;

    private String password;

    /**
     * 加密盐值
     */
    private String salt;

    /**
     * 用户所有角色值，用于shiro做角色权限的判断
     */
    private Set<String> roles;

    /**
     * 用户所有权限值，用于shiro做资源权限的判断
     */
    private Set<String> perms;


}
