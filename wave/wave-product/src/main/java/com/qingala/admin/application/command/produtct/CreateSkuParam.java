package com.qingala.admin.application.command.produtct;

import java.math.BigDecimal;

import com.qingala.admin.domain.product.model.SpecTuple;

import lombok.Data;

@Data
public class CreateSkuParam {


    /**
     * 建议零售价
     */
    private BigDecimal retailPrice;

    /**
     * 建议市场价
     */
    private BigDecimal marketPrice;

    /**
     * 一品多码
     */
    private String barCodes;//一品多码

    /**
     *规格属性
    */
    private SpecTuple specTuple;
    
}
