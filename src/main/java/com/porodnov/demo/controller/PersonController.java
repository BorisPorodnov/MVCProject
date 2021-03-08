package com.porodnov.demo.controller;

import com.porodnov.demo.model.Person;
import com.porodnov.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/person")
    public void creatPerson(@RequestBody List<Person> person) {
        personService.creatingNewPerson(person);
    }
}