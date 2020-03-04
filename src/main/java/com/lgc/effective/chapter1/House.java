package com.lgc.effective.chapter1;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author lgc
 **/
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class House {

    /**
     * 静态方法指定字段构造实例，避免字段过多导致多个构造方式，构造结果不直观
     * @param name
     * @param province
     * @return
     */
    public static House createHouseWithNameAndProvince(String name, String province) {
        return House.builder().name(name).province(province).build();
    }

    private String name;
    private String province;
    private int toiletCount;
    private float area;
    private BigDecimal price;

}
