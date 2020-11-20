package com.qingala.admin.domain.product.model;

import java.math.BigDecimal;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.vladmihalcea.hibernate.type.json.JsonStringType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Sku {
    
    @NotNull(message = "商家不能为空")
    private String shopId;
    @NotNull(message = "spuID不能为空")
    private String spuId;
    @NotNull(message = "skuID不能为空")
    private String skuId;
    
    @NotNull(message = "规格组不能为空")
    private SpecTuple specTuple;

    @NotNull(message = "条码列表不能为空")
    private String barCodes;

    @NotNull(message = "建议零售价不能为空")
    @Max(value = 999999900, message = "建议零售价最大为9999999元")
    @Min(value = 1, message = "建议零售价最小为0.01元")
    private BigDecimal retailPrice;

    @NotNull(message = "建议市场价不能为空")
    @Max(value = 999999900, message = "建议市场价最大为9999999元")
    @Min(value = 1, message = "建议市场价最小为0.01元")
    private BigDecimal marketPrice;
 
    public static Sku create(String shopId,String spuId,String skuId,SpecTuple specTuple,String barCodes,BigDecimal retailPrice,BigDecimal marketPrice ){
        return new Sku( shopId, spuId, skuId, specTuple, barCodes, retailPrice, marketPrice);
    }


}