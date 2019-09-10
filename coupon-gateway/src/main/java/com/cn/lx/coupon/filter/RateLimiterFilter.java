package com.cn.lx.coupon.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *限流过滤器
 * @author StevenLu
 * @date 2019-09-10 08:11
 */
@Slf4j
@Component
public class RateLimiterFilter extends AbstractPreZuulFilter {

    /**每秒获取2个令牌*/
    RateLimiter rateLimiter = RateLimiter.create(2.0);

    @Override
    public Object cRun() {

        HttpServletRequest request = context.getRequest();
        if(rateLimiter.tryAcquire()){
            log.info("获取token成功");
            return success();
        }else {
            log.error("限流失败:{}",request.getRequestURL());
            return fail(401,"error:拦截失败");
        }
    }

    /**
     * 优先级
     * @return
     */
    @Override
    public int filterOrder() {
        return 2;
    }
}
