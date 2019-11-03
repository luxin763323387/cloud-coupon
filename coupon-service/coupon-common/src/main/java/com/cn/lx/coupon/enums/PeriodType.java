package com.cn.lx.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author StevenLu
 * @date 2019-10-27 18:45
 */
@Getter
@AllArgsConstructor
public enum  PeriodType {

    /**
     * 固定日期
     */
    REGULAR("固定的(固定日期)", 1),
    /**
     * 变动日期
     */
    SHIFT("变动的(以领取之日开始计算)", 2);

    /** 有效期描述 */
    private String description;

    /** 有效期编码 */
    private Integer code;

    public static PeriodType of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " 不存在"));
    }
}
