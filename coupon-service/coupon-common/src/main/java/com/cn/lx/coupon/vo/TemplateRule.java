package com.cn.lx.coupon.vo;

import com.cn.lx.coupon.enums.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * 券规则
 * @author StevenLu
 * @date 2019-10-27 18:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateRule {

    /**
     * 优惠券过期规则
     */
    private Expiration expiration;

    /**
     * 满减规则
     */
    private Discount discount;

    /**
     *使用范围
     */
    private Usage usage;

    /**
     * 个人持有的优惠券上限
     */
    private Integer limitation;

    /** 权重(可以和哪些优惠券叠加使用, 同一类的优惠券一定不能叠加): list[], 优惠券的唯一编码 */
    private String weight;

    public boolean validate(){
        return expiration.validate() && discount.validate()
                && usage.validate() && limitation > 0
                && StringUtils.isNotEmpty(weight);
    }

    /**
     * 有效期限规则
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Expiration{

        /**
         * 有效期规则, 对应 PeriodType 的 code 字段
         */
        private Integer period;

        /**
         * 有效间隔(针对变动型的券)
         */
        private Integer gap;

        /**
         * 失效日期(变动和固定)
         */
        private Long deadline;

        boolean validate(){
            return null != PeriodType.of(period) && gap > 0 && deadline > 0;
        }
    }

    /**
     * 满减规则
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Discount{

        /**
         * 额度:满减(20), 折扣(85), 立减(10)
         */
        private Integer quota;

        /**
         * 基准，需要满多少才可以用
         */
        private Integer base;

        boolean validate(){
            return quota > 0 && base > 0;
        }
    }

    /**
     * 使用范围
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Usage{

        /**
         * 省份
         */
        private String province;

        /**
         * 城市
         */
        private String city;

        /** 商品类型, list[文娱, 生鲜, 家居, 全品类] */
        private String goodsType;

        boolean validate(){
            return StringUtils.isNotEmpty(province)
                    &&StringUtils.isNotEmpty(city)
                    &&StringUtils.isNotEmpty(goodsType);
        }
    }
}
