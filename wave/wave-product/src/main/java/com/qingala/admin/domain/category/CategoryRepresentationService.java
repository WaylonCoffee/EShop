package com.qingala.admin.domain.category;

import java.util.List;

import com.qingala.wave.common.jackson.DefaultObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepresentationService {
    
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();


    String SELECT_CATEGORY_SQL = "SELECT content FROM category";

    /**
     * 分类列表
     * @return
     */
    public List<Category> listSpus() {
        List<Category> categories = template.query(SELECT_CATEGORY_SQL,
                (rs, rowNum) -> mapper.readValue(rs.getString("content"),
                Category.class)
        );
        return categories;
    }



}