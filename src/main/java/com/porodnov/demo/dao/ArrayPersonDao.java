package com.porodnov.demo.dao;

import com.porodnov.demo.model.Person;
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

    public List<Person> findAll() {
        String sql =
            " SELECT *" +
                " FROM person per " +
                " INNER JOIN person_skill ps " +
                " ON per.person_id = ps.person_skill_person_id ";
        RowMapper<Person> rowMapper = (rs, rowNum) -> new Person()
            .setIds(rs.getInt("person_id"))
            .setName(rs.getString("person_name"))
            .setLastName(rs.getString("person_last_name"))
            .setSkills(findSkillPerson(findAlls(), findAllSkill()));
        return namedJdbcTemplate.query(sql, rowMapper);
    }

    public List<Person> findAlls() {
        String sql =
            " SELECT * " +
                " FROM person per " +
                " INNER JOIN person_skill ps " +
                " ON per.person_id = ps.person_skill_person_id" +
                " INNER JOIN  skill sk" +
                " ON ps.person_skill_skill_id = sk.skill_id";
        RowMapper<Person> rowMapper = (rs, rowNum) -> new Person()
            .setIds(rs.getInt("person_id"))
            .setName(rs.getString("person_name"))
            .setLastName(rs.getString("person_last_name"));
        return namedJdbcTemplate.query(sql, rowMapper);
    }

    public List<Skill> findAllSkill() {
        String sql = "Select * FROM skill";
        RowMapper<Skill> rowMapper = (rs, rowNum) -> new Skill()
            .setId(rs.getInt("skill_id"))
            .setName(rs.getString("skill_name"))
            .setLevel(rs.getByte("skill_level"));
        return namedJdbcTemplate.query(sql, rowMapper);
    }

    private ArrayList<Long> findSkillPerson(List<Person> personList, List<Skill> skillList) {
        ArrayList<Long> listPerson = new ArrayList<>();
        ArrayList<Long> listSkill = new ArrayList<>();
        ArrayList<Long> result = new ArrayList<>();
        for (Person person : personList) {
            listPerson.add(Long.valueOf(person.getIds()));
            for (Skill skill : skillList) {
                listSkill.add(Long.valueOf(skill.getId()));
            }
            for (Long idsPerson : listPerson) {
                for (Long idsSkill : listSkill) {
                    if (!idsPerson.equals(idsSkill)) {
                        result.add(idsSkill);
                    }
                }
            }
        }
        return result;
    }
}