package com.qingala.admin.domain.product;

import com.qingala.admin.application.command.produtct.CreateSpuParam;
import com.qingala.admin.domain.product.model.Spu;
import com.qingala.wave.common.utils.SnowFlake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.val;

@Service
public class SpuService {
    
    @Autowired
    private SpuRepository spuRepository;

    @Autowired
    private SkuService skuService;

    

    public String create(CreateSpuParam param){
        String shopId = param.getShopId();
        String spuId = SnowFlake.genId();
        val skus = skuService.createSkus(shopId, spuId, param.getSkus());
        Spu spu =Spu.create(shopId, spuId, param.getName(), param.getPhotoTuple(), param.getCategoryId(), param.getUnit(), skus);
        spuRepository.add(spu);
        return spuId;
    }


}
