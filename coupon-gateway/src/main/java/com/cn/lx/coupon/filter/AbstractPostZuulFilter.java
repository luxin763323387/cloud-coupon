package com.cn.lx.coupon.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 后置过滤器
 * @author StevenLu
 * @date 2019-09-10 07:45
 */
public abstract class AbstractPostZuulFilter extends AbstractZuulFilter{

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }
}
