package com.qingala.admin.domain.product;

import com.qingala.admin.domain.product.model.Spu;
import com.qingala.admin.infra.ProductErrorCode;
import com.qingala.wave.common.jackson.DefaultObjectMapper;
import com.qingala.wave.common.utils.PagedResource;
import com.qingala.wave.common.utils.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.google.common.collect.ImmutableMap.of;
import static com.google.common.collect.Maps.newHashMap;

import java.util.List;


@Repository
public class SpuRepository{
    
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final DefaultObjectMapper mapper = new DefaultObjectMapper();

    private final String INSERT_SPU_SQL = "insert into spu (id,content) values(:id,:content)  ON DUPLICATE KEY UPDATE content=:content;";

    private final String SELECT_SPU_SQL = "select content from spu limit :limit offset :offset;";
    private final String COUNT_SPU_SQL = "select count(1) from spu;";

    public void add(Spu spu){
        template.update(INSERT_SPU_SQL, of("id",spu.getSpuId(),"content",mapper.writeValueAsString(spu)));
    }


    public Spu byId(String id) {
        try {
            String sql = "SELECT content FROM spu WHERE ID=:id;";
            return template.queryForObject(sql, of("id", id), mapper());
        } catch (EmptyResultDataAccessException e) {
            throw new ServiceException(ProductErrorCode.SPU_NOT_FOUND,of("spuId",id));
        }
    }

    public PagedResource<Spu> listSpus(int pageIndex, int pageSize) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("limit", pageSize);
        parameters.addValue("offset", (pageIndex - 1) * pageSize);

        List<Spu> products = template.query(SELECT_SPU_SQL, parameters,
                (rs, rowNum) -> mapper.readValue(rs.getString("content"),
                        Spu.class)
        );

        int total = template.queryForObject(COUNT_SPU_SQL, newHashMap(), Integer.class);
        return PagedResource.of(total, pageIndex, products);
    }


    private RowMapper<Spu> mapper() {
        return (rs, rowNum) -> mapper.readValue(rs.getString("content"), Spu.class);
    }

}
