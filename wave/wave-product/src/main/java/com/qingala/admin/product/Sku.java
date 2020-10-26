package com.qingala.admin.product;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Sku {
    
    @NotNull(message = "商家不能为空")
    private String shopId;
    @NotNull(message = "spuID不能为空")
    private String spuId;
    @NotNull(message = "skuID不能为空")
    private String skuId;
    
    @NotNull(message = "规格组不能为空")
    private SpecTuple specTuple;

    @NotNull(message = "条码不能为空")
    private String no;
    @NotNull(message = "条码列表不能为空")
    private String barCodes;

    @NotNull(message = "建议零售价不能为空")
    @Max(value = 999999900, message = "建议零售价最大为9999999元")
    @Min(value = 1, message = "建议零售价最小为0.01元")
    private BigDecimal retailPrice;

    @NotNull(message = "建议市场价不能为空")
    @Max(value = 999999900, message = "建议零售价最大为9999999元")
    @Min(value = 1, message = "建议零售价最小为0.01元")
    private BigDecimal marketPrice;


}