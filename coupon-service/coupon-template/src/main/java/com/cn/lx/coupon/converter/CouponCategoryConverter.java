package com.cn.lx.coupon.converter;

import com.cn.lx.coupon.enums.CouponCategory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 优惠券分类转换器
 *  * AttributeConverter<X, Y>
 *  * X: 是实体属性的类型
 *  * Y: 是数据库字段的类型
 * @author StevenLu
 * @date 2019-10-27 19:38
 */
@Converter
public class CouponCategoryConverter implements AttributeConverter<CouponCategory, String> {

    /**
     * <h2>将实体属性X转换为Y存储到数据库中, 插入和更新时执行的动作</h2>
     * */
    @Override
    public String convertToDatabaseColumn(CouponCategory couponCategory) {
        return couponCategory.getCode();
    }

    /**
     * <h2>将数据库中的字段Y转换为实体属性X, 查询操作时执行的动作</h2>
     * */
    @Override
    public CouponCategory convertToEntityAttribute(String code) {
        return CouponCategory.of(code);
    }
}
