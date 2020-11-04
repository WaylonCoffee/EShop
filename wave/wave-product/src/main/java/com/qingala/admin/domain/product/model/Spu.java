package com.qingala.admin.domain.product.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Spu {
    
    @NotNull(message = "商家不能为空")
    private String shopId;

    @NotNull(message = "ID不能为空")
    @Id
    private String spuId;

    @NotNull(message = "名称不可为空")
    @Size(max = 100, min = 1, message = "名称字符数为1到100个字")
    private String name;

    @NotNull(message = "图片不能为空")
    @Type(type = "json")
    @Column(columnDefinition = "json" )
    private PhotoTuple photoTuple;

    @NotNull(message = "分类不能为空")
    private String categoryId;

    @NotNull(message = "单位不能为空")
    private String unit;

    @Size(max = 600, message = "规格数最大不能超过600")
    @Transient 
    private List<Sku> skus = new ArrayList<>();

    public static Spu create(String shopId,String spuId,String name,PhotoTuple photoTuple,String categoryId,String unit,List<Sku> skus) {
        return new Spu(shopId,spuId,name, photoTuple, categoryId, unit, skus);
    }

}