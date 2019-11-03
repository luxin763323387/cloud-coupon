package com.cn.lx.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 流水线
 * @author StevenLu
 * @date 2019-10-27 17:15
 */
@Getter
@AllArgsConstructor
public enum ProductLine {

    /**
     * 天猫
     */
    DAMAO("天猫", 1),

    /**
     * 淘宝
     */
    DABAO("淘宝", 2);

    private String description;

    private Integer code;

    public static ProductLine of(Integer code){

        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(p -> p.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + "不存在"));
    }
}
