package com.porodnov.demo.service;

import com.porodnov.demo.dao.ArrayPersonDao;
import com.porodnov.demo.dto.PersonFilter;
import com.porodnov.demo.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArrayPersonService {

    private final ArrayPersonDao arrayPersonDao;

    public List<Person> getArrayPersonService(PersonFilter personFilter) {
        return arrayPersonDao.getArrayPersonDao(personFilter);
    }
}
