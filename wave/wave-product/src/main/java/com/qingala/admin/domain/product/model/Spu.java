package com.qingala.admin.domain.product.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public static Spu create(String shopId,String spuId,String name,PhotoTuple photoTuple,String categoryId,String unit,List<Sku> skus) {
        return new Spu(shopId,spuId,name, photoTuple, categoryId, unit, skus);
    }

}