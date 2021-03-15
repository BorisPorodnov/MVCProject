package com.porodnov.demo.dao;

import com.porodnov.demo.model.PersonById;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonByIdDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PersonById getPersonIdDao() {
        return null;
    }
}
