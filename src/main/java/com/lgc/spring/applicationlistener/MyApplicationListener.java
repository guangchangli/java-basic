package com.lgc.spring.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author lgc
 **/
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    /**
     * 基于事件开发
     * 监听器 监听某个事件 ApplicationEvent及其子类
     * 把监听器加入到容器
     * 只要容器中有相关事件的发布 就可以监听到事件
     *
     * 容器刷新
     * 创建派发器
     * 注册事件
     *
     * @EventListener({})
     * EventListenerMethodProcessor
     *
     * SmartInitializingSingleton
     */

    /**
     * 收到事件 触发
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        /**
         * ContextRefreshedEvent
         * ContextClosedEvent
         */
        System.out.println("收到的事件： "+event);
    }
}
