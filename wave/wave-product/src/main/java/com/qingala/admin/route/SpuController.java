package com.qingala.admin.route;

import com.qingala.admin.application.command.produtct.CreateSpuParam;
import com.qingala.admin.domain.product.SpuService;
import com.qingala.admin.domain.product.model.Spu;
import com.qingala.admin.domain.product.representation.SpuRepresentationService;
import com.qingala.wave.common.utils.PagedResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.Map;

import javax.validation.Valid;

import static com.google.common.collect.ImmutableMap.of;

@RestController
@RequestMapping("spu")
public class SpuController {
   
    @Autowired
    private SpuService spuService;

    @Autowired
    private SpuRepresentationService spuRepresentationService;


    @PostMapping
    @ResponseStatus(CREATED)
    public Map<String, String> create(@RequestBody @Valid CreateSpuParam spuParam){
        
        return of("id", spuService.create(spuParam));
    }

    @GetMapping
    public PagedResource<Spu> pagedProducts(@RequestParam(required = false, defaultValue = "1") int pageIndex,
                                                                   @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return spuRepresentationService.listSpus(pageIndex, pageSize);
    }


    @GetMapping("/{spuId}")
    public Spu detail(@PathVariable(name = "spuId") String spuId){
        return null;
    }

}
