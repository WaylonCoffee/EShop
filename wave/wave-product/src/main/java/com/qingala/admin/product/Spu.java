package com.qingala.admin.product;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spu {
    
    @NotNull(message = "商家不能为空")
    private String shopId;

    @NotNull(message = "ID不能为空")
    private String spuId;

    @NotNull(message = "名称不可为空")
    @Size(max = 100, min = 1, message = "名称字符数为1到100个字")
    private String name;

    @NotNull(message = "图片不能为空")
    private PhotoTuple photoTuple;

    @NotNull(message = "分类不能为空")
    private String categoryId;

    @NotNull(message = "单位不能为空")
    private String unit;

    @Size(max = 600, message = "规格数最大不能超过600")
    private List<Sku> skus = new ArrayList<>();



}