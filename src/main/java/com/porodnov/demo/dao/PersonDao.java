package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void getNewPerson(List<Person> person) {
        String sql =
                " INSERT INTO person( person_name, person_last_name) " +
                " VALUES(:name, :lastName) ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", person.get(0).getName());
        map.addValue("lastName", person.get(0).getLastName());
        jdbcTemplate.update(sql, map);
        sql =
                " INSERT INTO person( person_name, person_last_name) " +
                " VALUES(:name, :lastName) ";
        MapSqlParameterSource map1 = new MapSqlParameterSource();
        map1.addValue("name", person.get(1).getName());
        map1.addValue("lastName", person.get(1).getLastName());
        jdbcTemplate.update(sql, map1);
    }
}
