package com.qingala.admin.route;

import com.qingala.admin.domain.product.SpuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spu")
public class SpuController {
   
    @Autowired
    private SpuService spuService;

    public void create(){

        
    }


}
