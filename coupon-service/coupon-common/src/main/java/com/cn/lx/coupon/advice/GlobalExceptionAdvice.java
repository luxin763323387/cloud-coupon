package com.cn.lx.coupon.advice;

import com.cn.lx.coupon.exception.CouponException;
import com.cn.lx.coupon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @author StevenLu
 * @date 2019-09-15 08:30
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * CouponException统一处理
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(CouponException.class)
    public CommonResponse<String> handlerException(
            HttpServletRequest request, CouponException ex){

        CommonResponse<String> commonResponse = new CommonResponse<String>(
                -1,"business error");
        commonResponse.setData(ex.getMessage());
        return commonResponse;
    }
}
