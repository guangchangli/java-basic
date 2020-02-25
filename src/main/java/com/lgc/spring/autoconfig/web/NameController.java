package com.lgc.spring.autoconfig.web;

import com.lgc.spring.autoconfig.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author lgc
 * @create 2020-02-25
 **/
@Controller
public class NameController {
    @Autowired
    NameService nameService2;

    @Override
    public String toString() {
        return "nameService = [ nameService=" + nameService2 + "]";
    }

}
