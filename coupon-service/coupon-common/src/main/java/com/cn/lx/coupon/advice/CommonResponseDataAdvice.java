package com.cn.lx.coupon.advice;

import com.cn.lx.coupon.annotation.IgnoreResponseAdvice;
import com.cn.lx.coupon.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一响应
 * @author StevenLu
 * @date 2019-09-15 08:01
 */
@RestControllerAdvice
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {

        //如果controller包含注解返回false
        if(returnType.getDeclaringClass().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }

        //如果service包含注解返回false
        if(returnType.getMethod().isAnnotationPresent(
                IgnoreResponseAdvice.class
        )){
            return false;
        }

        //其他返回true；
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        CommonResponse commonResponse = new CommonResponse(0,"");

        /**
         * 如果o为null返回空commonResponse
         * 如果o属于CommonResponse类型 强转返回
         * 否则返回o
         */
        if(o == null){
            return commonResponse;
        }if(o instanceof CommonResponse){
            commonResponse = (CommonResponse<Object>) o;
        }else {
            commonResponse.setData(o);
        }

        return commonResponse;
    }
}
