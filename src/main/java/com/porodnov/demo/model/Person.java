package com.porodnov.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Person {
    private int id;
    private String name;
    private String lastName;
    private List<Skill> skills;
}