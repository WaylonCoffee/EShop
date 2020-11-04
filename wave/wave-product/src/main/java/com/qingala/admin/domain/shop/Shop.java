package com.qingala.admin.domain.shop;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
    
    @NotNull(message = "店铺ID不能为空")
    private String id;

    @NotNull(message = "店铺名不能为空")
    private String name;
    
    @NotNull(message = "店铺logo不能为空")
    private String logo;

}
