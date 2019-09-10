package com.cn.lx.coupon.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 通用的抽象过滤器类
 * @author StevenLu
 * @date 2019-09-07 08:37
 */
public abstract class AbstractZuulFilter extends ZuulFilter {

    /**
     * 用于在过滤器中传递消息，数据保存在每一个ThreadLocal中
     * 用于扩展map
     */
    RequestContext context;

    private static final String NEXT = "next";

    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        return (boolean)ctx.getOrDefault(NEXT,true);
    }

    @Override
    public Object run() throws ZuulException {

        context = RequestContext.getCurrentContext();
        return cRun();
    }

    public abstract Object cRun();

    /**
     * 过滤器失败返回fail
     * @param code
     * @param message
     * @return
     */
    Object fail(int code,String message){

        context.set(NEXT,false); //map中放false
        context.setSendZuulResponse(false); //zuul响应false
        context.getResponse().setContentType("text/html;charset=UTF-8");//定义ContentType
        context.setResponseStatusCode(code); //响应错误码
        context.setResponseBody(String.format(
                "{\"result\": \"%s!\"}", message
        ));//响应错误信息

        return null;
    }

    /**
     * 过滤器成功返回success
     * @return
     */
    Object success(){
        context.set(NEXT,true);
        return null;
    }

}
