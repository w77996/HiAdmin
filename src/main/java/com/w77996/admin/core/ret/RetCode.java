package com.w77996.admin.core.ret;

import lombok.AllArgsConstructor;

/**
 * @description: 响应码枚举，参考HTTP状态码的语义
 * @author: w77996
 * @create: 2018-11-08 17:38
 **/
@AllArgsConstructor
public enum  RetCode {
    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    /** 未登录 */
    UNAUTHEN(4401),

    /** 未授权，拒绝访问 */
    UNAUTHZ(4403),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;



}
