package com.cn.lx.coupon.exception;

import lombok.Data;

/**
 * 统一异常处理
 * @author StevenLu
 * @date 2019-09-15 08:28
 */
@Data
public class CouponException extends Exception {

    private Integer code;

    public CouponException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
