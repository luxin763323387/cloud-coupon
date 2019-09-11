package com.cn.lx.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 后置过滤器获取时间
 * @author StevenLu
 * @date 2019-09-10 22:08
 */
@Slf4j
@Component
public class PostLogFilter extends AbstractPostZuulFilter{


    @Override
    public Object cRun() {

        HttpServletRequest request = context.getRequest();

        // 从 PreRequestFilter 中获取设置的请求时间戳
        Long time = (Long) context.get("startTime");
        long spendTime = System.currentTimeMillis() - time;
        StringBuffer requestURL = request.getRequestURL();

        // 从网关通过的请求都会打印日志记录: uri + duration
        log.info("请求耗时:{}，请求URL:{}",spendTime,requestURL);

        return null;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1;
    }
}
