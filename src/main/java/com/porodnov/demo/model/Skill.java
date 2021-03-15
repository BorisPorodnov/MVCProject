package com.porodnov.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Skill {
    @JsonProperty("skill_id")
    private int id;
    @JsonProperty("skill_name")
    private String name;
    @JsonProperty("skill_level")
    private int level;
}
