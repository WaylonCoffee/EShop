package com.qingala.admin.domain.product;

import com.qingala.admin.domain.product.model.Spu;
import com.qingala.admin.infra.dao.SkuDao;
import com.qingala.admin.infra.dao.SpuDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




@Repository
public class SpuRepository{

    @Autowired
    private SkuDao skuDao;

    @Autowired
    private SpuDao spuDao;
    
    @Transactional(rollbackFor = Exception.class)
    public void add(Spu spu){
        
       spuDao.save(spu);
       skuDao.saveAll(spu.getSkus());
    }

}
