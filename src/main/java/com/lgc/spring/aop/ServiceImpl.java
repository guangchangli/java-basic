package com.lgc.spring.aop;

import org.springframework.stereotype.Service;

/**
 * @author lgc
 * @create 2020-02-27
 **/
@Service("myService")
public class ServiceImpl implements MyService {
    @AopAnnotation
    @Override
    public void query() {
        System.out.println("query");
    }

    @Override
    public void query1(String i) {
        System.out.println("query1 "+i);

    }
}
