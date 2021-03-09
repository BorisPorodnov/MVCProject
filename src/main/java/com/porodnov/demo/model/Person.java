package com.porodnov.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;

@Getter
@Setter
@Accessors(chain = true)
public class Person {
    @JsonProperty("person_id")
    private  long  id;
    @JsonProperty("person_name")
    private String name;
    @JsonProperty("person_last_name")
    private String lastName;

    private ArrayList<Long> skills;
}