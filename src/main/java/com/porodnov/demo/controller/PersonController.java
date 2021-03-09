package com.porodnov.demo.controller;

import com.porodnov.demo.model.Person;
import com.porodnov.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public long creatPerson(@RequestBody Person person) {
      return   personService.creatingNewPerson(person);
    }
}