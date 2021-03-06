package com.porodnov.demo.service;

import com.porodnov.demo.dao.TestDao;
import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestDao testDao;

    public List<Person> getTest() {
        return testDao.getDaoTest();
    }
}
