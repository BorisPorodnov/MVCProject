package com.porodnov.demo.controller;

import com.porodnov.demo.model.Person;
import com.porodnov.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class PersonController {

    private final TestService testService;

    @GetMapping("/hoho")
    public List<Person> creatPerson(){
        return testService.getTest();
    }
}