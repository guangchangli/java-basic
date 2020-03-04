package com.lgc.test.effective;

import com.lgc.effective.chapter1.House;
import org.junit.Test;

/**
 * @author lgc
 **/
public class ClassCreate {

    @Test
    public void testCreateUserStaticMethod(){
        House houseWithNameAndProvince = House.createHouseWithNameAndProvince("观澜一号", "豫");
        System.out.println(houseWithNameAndProvince);
    }

}
