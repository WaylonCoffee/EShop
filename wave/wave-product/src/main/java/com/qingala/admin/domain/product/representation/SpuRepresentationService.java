package com.qingala.admin.domain.product.representation;

import java.util.Optional;

import com.qingala.admin.domain.product.SpuRepository;
import com.qingala.admin.domain.product.model.Spu;
import com.qingala.wave.common.utils.PagedResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpuRepresentationService {
    
    @Autowired
    private SpuRepository spuRepository;

    public PagedResource<Spu> listSpus(int pageIndex, int pageSize) {
        return spuRepository.listSpus(pageIndex, pageSize);
    }

    public Optional<Spu> findById(String spuId) {
        return Optional.ofNullable(spuRepository.byId(spuId));
    }

}
