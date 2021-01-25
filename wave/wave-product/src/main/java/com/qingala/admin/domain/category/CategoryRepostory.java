package com.qingala.admin.domain.category;

import com.qingala.admin.infra.ProductErrorCode;
import com.qingala.wave.common.jackson.DefaultObjectMapper;
import com.qingala.wave.common.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.google.common.collect.ImmutableMap.of;

@Repository
public class CategoryRepostory {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private final String INSERT_SPU_SQL = "insert into spu (id,content) values(:id,:content)  ON DUPLICATE KEY UPDATE content=:content;";



    public void add(Category category){
        template.update(INSERT_SPU_SQL, of("id",category.getId(),"content",mapper.writeValueAsString(category)));
    }


    public Category byId(String id) {
        try {
            String sql = "SELECT content FROM spu WHERE ID=:id;";
            return template.queryForObject(sql, of("id", id), mapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceException(ProductErrorCode.CATEGORY_NOT_FOUND,of("categoryId",id));
        }
    }

    private RowMapper<Category> mapper() {
        return (rs, rowNum) -> mapper.readValue(rs.getString("content"), Category.class);
    }



    
}

