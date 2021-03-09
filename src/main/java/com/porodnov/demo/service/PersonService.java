package com.porodnov.demo.service;

import com.porodnov.demo.dao.PersonDao;
import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonDao personDao;

    public long creatingNewPerson(Person person) {
       return personDao.createNewPerson(person);
    }
}
