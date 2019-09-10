package com.cn.lx.coupon.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * token过滤器
 * @author StevenLu
 * @date 2019-09-10 07:55
 */
@Slf4j
@Component
public class TokenFilter extends AbstractPreZuulFilter {
    @Override
    public Object cRun() {

        HttpServletRequest request = context.getRequest();
        log.info("%s request %s", request.getMethod(), request.getRequestURL());

        //获取token
        Object token = request.getParameter("token");
        if(token == null){
            log.error("error: token is empty");
            return fail(401, "error: token is empty");
        }

        return success();
    }

    /**
     * 数字越低，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }
}
