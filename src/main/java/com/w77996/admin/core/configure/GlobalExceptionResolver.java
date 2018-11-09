package com.w77996.admin.core.configure;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.w77996.admin.core.exception.ServiceException;
import com.w77996.admin.core.ret.RetCode;
import com.w77996.admin.core.ret.RetResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class GlobalExceptionResolver {

    @ExceptionHandler(UnauthenticatedException.class)
    public void page401(HttpServletResponse response, UnauthenticatedException e) {
        RetResult<Object> result = new RetResult<>();
        result.setCode(RetCode.UNAUTHEN).setMsg("用户未登录").setData(null);
        responseResult(response, result);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public void page403(HttpServletResponse response) {
        RetResult<Object> result = new RetResult<>();
        result.setCode(RetCode.UNAUTHZ).setMsg("用户没有访问权限").setData(null);
        responseResult(response, result);
    }
    /**
     * 业务异常的处理
     */
    @ExceptionHandler(value = ServiceException.class)
    public void serviceExceptionHandler(HttpServletResponse response, ServiceException e) {
        RetResult<Object> result = new RetResult<>();
        result.setCode(RetCode.FAIL).setMsg(e.getMessage()).setData(null);
        responseResult(response, result);
    }
    /**
     * 其他异常统一处理
     */
    @ExceptionHandler(value = Exception.class)
    public void exceptionHandler(HttpServletResponse response, Exception e) {
        RetResult<Object> result = new RetResult<>();
        result.setCode(RetCode.INTERNAL_SERVER_ERROR).setMsg("服务器打酱油了，请稍后再试~");
        log.error(e.getMessage(), e);
        responseResult(response, result);
    }
    /**
     * @param response
     * @param result
     * @Title: responseResult
     * @Description: 响应结果
     * @Reutrn void
     */
    private void responseResult(HttpServletResponse response, RetResult<Object> result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
