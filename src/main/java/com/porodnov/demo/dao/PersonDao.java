package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Person> getDaoTest() {

      String  sql = " SELECT * FROM person ";

        RowMapper<Person> responseMapper = (rs, rowNum) -> new Person()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setLastName(rs.getString("last_name"));
        return jdbcTemplate.query(sql, responseMapper);
    }

}
