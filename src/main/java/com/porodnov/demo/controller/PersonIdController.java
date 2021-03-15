package com.porodnov.demo.controller;

import com.porodnov.demo.model.PersonById;
import com.porodnov.demo.service.PersonByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonIdController {

    private final PersonByIdService personByIdService;

    @GetMapping("/person/[id]")
    public PersonById getPersonById() {
        return personByIdService.getPersonById();
    }

}
