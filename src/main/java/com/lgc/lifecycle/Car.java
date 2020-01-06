package com.lgc.lifecycle;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author lgc
 * @create 2020-01-06 7:13 下午
 **/
@Data
@Builder
public class Car implements InitializingBean{
    private String name;
    private String county;
    private int price;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("---2.cat propertiesSet finished");
    }
    @PostConstruct
    public void init(){
        System.out.println("---1.after car construct");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("---4.ready to destroy car");
    }


    private void initCat() {
        System.out.println("---3.initMethod init car ");
    }

    private void destroyCar() {
        System.out.println("---5.destroyMethod destroy car");
    }
}
