package com.qingala.admin.domain.category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Category {

    @NotNull(message = "分类ID不能为空")
    private String id;

    @NotNull(message = "名称不能为空")
    @Size(min = 1, max = 20, message = "分类名称字符数在1-20之间")
    private String name;

    private int order;

    public static Category create(String id,String name, int order) {
        return new Category(id,name, order);
    } 

}
