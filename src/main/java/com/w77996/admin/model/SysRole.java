package com.w77996.admin.model;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {
    private String id;

    private String roleName;

    private String roleDesc;

    private String roleValue;

    private Date createTime;

    private Date updateTime;

    private Integer isDisable;

}