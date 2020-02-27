package com.lgc.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 *
 * @author lgc
 * @create 2020-01-13 12:00 下午
 **/
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.lgc.spring.aop"})
public class AopConfig {

    /**
     * 程序运行期间将某段代码加入指定位置
     * 将业务逻辑类和切面类加入到容器中
     * 配置类添加 @EnableAspectAutoProxy 开启 aop
     */

    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }

    /**
     * 应用场景
     * 1、处理一些通用的非功能性的需求，不影响业务流程，比如说打印日志、性能统计、推送消息等；
     * 2、aop无法拦截static、final方法、private方法
     * 3、无法拦截内部方法调用 (本类方法不回触发，调用其他类会触发)
     *
     * aop 原理
     * EnableAspectJAutoProxy import AspectJAutoProxyRegistrar
     * import : AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar
     */

}
