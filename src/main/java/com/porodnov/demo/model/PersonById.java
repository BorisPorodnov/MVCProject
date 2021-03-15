package com.porodnov.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonById {
    @JsonProperty("person_id")
    private long id;
    @JsonProperty("person_name")
    private String name;
    @JsonProperty("person_last_name")
    private String lastName;
}
