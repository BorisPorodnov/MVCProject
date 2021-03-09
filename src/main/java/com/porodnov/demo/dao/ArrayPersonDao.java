package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArrayPersonDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Person> getArrayPersonDao() {
        String sql =
            " SELECT person_id, person_name, person_last_name " +
            " FROM person ps " +
            " WHERE ps.person_id  > 30 " +
            " AND ps.person_id < 50 ";
        RowMapper<Person> rowMapper = (rs, rowNum) -> new Person()
            .setId(rs.getInt("person_id"))
            .setName(rs.getString("person_name"))
            .setLastName(rs.getString("person_last_name"));

        return jdbcTemplate.query(sql, rowMapper);
    }
}