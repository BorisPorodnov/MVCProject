package com.porodnov.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonResponse {
    @JsonProperty("person_skill_skill_id")
    private int skillId;
    @JsonProperty("person_skill_person_id")
    private int personId;
}
