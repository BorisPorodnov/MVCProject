package com.porodnov.demo.service;

import com.porodnov.demo.dao.PersonDao;
import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public void creatingNewPerson(List <Person> person) {
        personDao.getNewPerson(person);
    }
}
