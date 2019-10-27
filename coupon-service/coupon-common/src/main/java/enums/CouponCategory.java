package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * 优惠券分类
 * @author StevenLu
 * @date 2019-10-27 16:55
 */
@Getter
@AllArgsConstructor
public enum CouponCategory {


    /**
     * 满减
     */
    MANJIAN("满减券", "001"),
    /**
     * 折扣
     */
    ZHEKOU("折扣券", "002"),
    /**
     * 立减
     */
    LIJIAN("立减券", "003");

    private String code;

    private String description;

    public static CouponCategory of(String code){

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(c -> c.getCode().equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " 不存在"));
    }
}
