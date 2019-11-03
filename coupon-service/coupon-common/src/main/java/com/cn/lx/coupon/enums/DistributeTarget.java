package com.cn.lx.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 分发目标
 * @author StevenLu
 * @date 2019-10-27 17:10
 */
@Getter
@AllArgsConstructor
public enum DistributeTarget {

    /**
     * 单用户
     */
    SINGLE("单用户", 1),

    /**
     * 多用户
     */
    MULTI("多用户", 2);

    private String description;

    private Integer code;


    public static DistributeTarget of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
    }


}
