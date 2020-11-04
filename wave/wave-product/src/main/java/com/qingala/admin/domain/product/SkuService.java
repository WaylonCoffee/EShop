package com.qingala.admin.domain.product;

import java.util.List;
import java.util.stream.Collectors;

import com.qingala.admin.application.command.produtct.CreateSkuParam;
import com.qingala.admin.domain.product.model.Sku;
import com.qingala.wave.common.utils.SnowFlake;

import org.springframework.stereotype.Service;

@Service
public class SkuService {
    

    public List<Sku> createSkus(String shopId,String spuId,List<CreateSkuParam> param){
        
        List<Sku> skuList = param.stream().map(s -> {
                String skuId = SnowFlake.genId();
                return Sku.create(shopId, spuId, skuId, s.getSpecTuple(), s.getBarCodes(), s.getRetailPrice(), s.getMarketPrice());
            }).collect(Collectors.toList()); 
        return skuList;

    }


}
