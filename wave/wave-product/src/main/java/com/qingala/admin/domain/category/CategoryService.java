package com.qingala.admin.domain.category;

import com.qingala.admin.application.command.category.CreateCategoryParam;
import com.qingala.wave.common.utils.SnowFlake;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepostory categoryRepostory;

    public String create(CreateCategoryParam param){
        String categoryId = SnowFlake.genId();
        Category category = Category.create(categoryId, param.getName(), param.getOrder());
        categoryRepostory.add(category);
        return "";
    } 

}
