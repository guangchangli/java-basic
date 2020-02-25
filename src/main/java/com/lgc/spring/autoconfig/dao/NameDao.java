package com.lgc.spring.autoconfig.dao;

import org.springframework.stereotype.Repository;

/**
 * @author lgc
 * @create 2020-02-25
 **/
@Repository
public class NameDao {
    private String label="1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "NameDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
