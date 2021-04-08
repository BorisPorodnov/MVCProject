package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
import com.porodnov.demo.model.PersonResponse;
import com.porodnov.demo.model.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArrayPersonDao {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;

    public List<Person> findById() {
        String sql =
            " SELECT * " +
                " FROM person " +
                " WHERE person_id = 68 ";
        RowMapper<Person> rowMapper = (rs, rowNum) -> new Person()
            .setIds(rs.getLong("person_id"))
            .setName(rs.getString("person_name"))
            .setLastName(rs.getString("person_last_name"));
        List<Person> listPerson = namedJdbcTemplate.query(sql, rowMapper);
        List<PersonResponse> listById = findPersonById();
        List<Skill> skillList = findSkillById();
        listPerson.get(0).setSkills((ArrayList<Skill>) skillList);

        return listPerson;
    }

    private List<PersonResponse> findPersonById() {
        String sql =
            " SELECT * FROM person_skill " +
                " WHERE person_skill_person_id = 68 ";
        RowMapper<PersonResponse> Mapper = (rs, rowNum) -> new PersonResponse()
            .setPersonId(rs.getInt("person_skill_person_id"))
            .setSkillId(rs.getInt("person_skill_person_id"));
        return namedJdbcTemplate.query(sql, Mapper);
    }

    private List<Skill> findSkillById() {
        String sql;
        sql =
            " SELECT * FROM skill" +
                " WHERE skill_id = 12 " +
                " OR skill_id = 13 ";
        RowMapper<Skill> rowMap = (rs, rowNum) -> new Skill()
            .setId(rs.getInt("skill_id"))
            .setName(rs.getString("skill_name"))
            .setLevel(rs.getInt("skill_level"));
        return namedJdbcTemplate.query(sql, rowMap);
    }

}