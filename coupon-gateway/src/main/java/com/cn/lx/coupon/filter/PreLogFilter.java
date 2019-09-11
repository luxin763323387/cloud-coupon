package com.cn.lx.coupon.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 获取请求前时间
 * @author StevenLu
 * @date 2019-09-10 22:04
 */
@Slf4j
@Component
public class PreLogFilter extends AbstractPreZuulFilter {

    @Override
    public Object cRun() {

        context.set("startTime",System.currentTimeMillis());
        return success();
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
