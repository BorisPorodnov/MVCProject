package com.porodnov.demo.controller;

import com.porodnov.demo.dto.PersonFilter;
import com.porodnov.demo.model.Person;
import com.porodnov.demo.service.ArrayPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class ArrayPersonController {

    private final ArrayPersonService arrayPersonService;

    @GetMapping("/persons")
    public List<Person> getArrayPerson(PersonFilter personFilter)
    {
        return arrayPersonService.getArrayPersonService(personFilter);
    }
}
