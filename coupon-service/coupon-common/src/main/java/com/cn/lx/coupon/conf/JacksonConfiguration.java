package com.cn.lx.coupon.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Jackson的自定义变化
 * @author StevenLu
 * @date 2019-09-14 10:52
 */
@Configuration
public class JacksonConfiguration {

    @Bean
    public ObjectMapper getObjectMapper(){

        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        );
        return mapper;
    }
}
