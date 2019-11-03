package com.cn.lx.coupon.converter;

import com.cn.lx.coupon.enums.ProductLine;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 产品线
 * @author StevenLu
 * @date 2019-10-27 19:44
 */
@Converter
public class ProductLineConverter
        implements AttributeConverter<ProductLine, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductLine productLine) {
        return productLine.getCode();
    }

    @Override
    public ProductLine convertToEntityAttribute(Integer code) {
        return ProductLine.of(code);
    }
}
