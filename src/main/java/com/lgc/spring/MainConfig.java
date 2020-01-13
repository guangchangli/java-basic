package com.lgc.spring;

import com.lgc.spring.condition.MyConditional;
import org.springframework.context.annotation.*;

/**
 * @author lgc
 * @create 2020-01-13 9:28 上午
 **/
@Configuration
@ComponentScan("com.lgc.spring")
//@Import({Lgc.class,MyImportSelector.class})
public class MainConfig {
//    @Lazy
    @Conditional(MyConditional.class)
    @Bean(initMethod = "init", destroyMethod = "destroy1")
    public Lgc lgc1() {
        return new Lgc();
    }
}
