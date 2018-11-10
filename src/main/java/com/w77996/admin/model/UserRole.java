package com.w77996.admin.model;

import lombok.Data;

@Data
public class UserRole {
    private String id;

    /**
     * 用户ID
     */
    private String userId;

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
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }


}