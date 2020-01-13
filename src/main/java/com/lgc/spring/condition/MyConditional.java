package com.lgc.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author lgc
 * @create 2020-01-13 9:29 上午
 **/
public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (conditionContext.getEnvironment().getProperty("os.name").contains("Mac")
                || conditionContext.getEnvironment().getActiveProfiles().equals("dev")) {
            return true;
        }
        return false;
    }
}
