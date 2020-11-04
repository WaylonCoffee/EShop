package com.qingala.admin.infra.dao;

import com.qingala.admin.domain.product.model.Sku;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuDao extends CrudRepository<Sku,String>{
    
}
