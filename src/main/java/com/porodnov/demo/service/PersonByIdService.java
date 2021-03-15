package com.porodnov.demo.service;

import com.porodnov.demo.dao.PersonByIdDao;
import com.porodnov.demo.model.PersonById;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonByIdService {

    private  final PersonByIdDao personByIdDao;

    public PersonById getPersonById() {
        return personByIdDao.getPersonIdDao();
    }
}
