package com.porodnov.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PersonResponse {
    @JsonProperty("person_name")
    private String name;
    @JsonProperty("person_id")
    private long id;

}
