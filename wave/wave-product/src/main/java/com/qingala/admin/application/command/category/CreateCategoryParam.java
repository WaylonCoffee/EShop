package com.qingala.admin.application.command.category;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateCategoryParam {
    
   
    /**
     * 分类名称
     */
    @NotNull(message = "分类名称不能为空")
    private String name;

    /**
     * 排序
     */
    @NotNull(message = "排序不能为空")
    private int order;


}
