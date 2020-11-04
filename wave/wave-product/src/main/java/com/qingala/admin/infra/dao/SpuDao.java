package com.qingala.admin.infra.dao;

import com.qingala.admin.domain.product.model.Spu;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuDao extends CrudRepository<Spu,String>  {
    
}
