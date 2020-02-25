package com.lgc.spring.autoconfig.service;

import com.lgc.spring.autoconfig.dao.NameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lgc
 * @create 2020-02-25
 **/
@Service
public class NameService {

//    @Qualifier("nameDao")
//    @Autowired(required = false)
    @Resource(name = "nameDao2")
    private NameDao nameDao;

    @Override
    public String toString() {
        return "NameService [ nameDao= " + nameDao +
                ']';
    }
}
