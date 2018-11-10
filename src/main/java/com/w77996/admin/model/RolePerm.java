package com.w77996.admin.model;


public class RolePerm {
    private String id;

    /**
     * 权限id
     */
    private String permId;

    /**
     * 角色id
     */
    private String roleId;


    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    /**
     * 设置权限id
     *
     * @param permId 权限id
     */
    public void setPermId(String permId) {
        this.permId = permId == null ? null : permId.trim();
    }


    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}