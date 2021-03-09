package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public long createNewPerson(Person person) {

        String sql =
            " INSERT INTO person( person_name, person_last_name) " +
                " VALUES(:name, :lastName) ";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("name", person.getName());
        map.addValue("lastName", person.getLastName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, map, keyHolder, new String[]{"person_id"});
        long update = keyHolder.getKey().longValue();
        person.getSkills().forEach(skill -> {
            String sql1 =
                " INSERT INTO person_skill (person_skill_person_id, person_skill_skill_id)" +
                " VALUES (:personId, :skillId)";
            MapSqlParameterSource map1 = new MapSqlParameterSource();
            map1.addValue("personId", update);
            map1.addValue("skillId", skill);
            jdbcTemplate.update(sql1, map1);
        });
        return update;
    }
}
