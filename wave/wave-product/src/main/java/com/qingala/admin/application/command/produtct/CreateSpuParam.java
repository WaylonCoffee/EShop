package com.qingala.admin.application.command.produtct;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.qingala.admin.domain.product.model.PhotoTuple;
import com.qingala.admin.domain.product.model.SpecTuple;

import lombok.Data;

@Data
public class CreateSpuParam {

    private String shopId;

    /**
     * 分类
     */
    @NotNull(message = "商品分类不能为空")
    private String categoryId;

    /**
     * 单位
     */
    @NotNull(message = "单位不能为空")
    private String unit;
    /**
     * 名称
     */
    private String name;

    /**
     * 图片地址 如不设置 前端会默认传一个默认图片 json格式
     */
    private PhotoTuple photoTuple;

    /**
     * 商品规格保存参数S
     */
    @Size(max = 600 , message = "最多支持600个规格")
    private List<CreateSkuParam> skus = new ArrayList<>();
}
