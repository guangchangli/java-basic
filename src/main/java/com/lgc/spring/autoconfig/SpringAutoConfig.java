package com.lgc.spring.autoconfig;

import com.lgc.spring.autoconfig.dao.NameDao;
import com.lgc.spring.autoconfig.service.NameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author lgc
 * @create 2020-02-25
 **/
@Configuration
@ComponentScan({"com.lgc.spring.autoconfig.service","com.lgc.spring.autoconfig.web","com.lgc.spring.autoconfig.dao","com.lgc.spring.autoconfig.entity"})
public class SpringAutoConfig {
    /**
     *  自动装配 di
     *   AutoWired spring支持
     *      1.默认优先按照类型去容器中找对应组件
     *      2.如果存在多个相同类型组件，再将属性名称作为组件的id去容器寻找
     *              application.getBean("")
     *      3.Qualifier("") 使用@Qualifier指定需要装配的组件id，而不是属性名
     *              autoWired(require=false)
     *      4.Primary 首选 qualifier 优先级更高
     *      5.Resource(jsr250) 名称注入  没有 4
     *        Inject(jsr330) 需要导入javax.inject 和autowired 一样
     *       AutowiredAnnotationBeanPostProcessor
     *   位置 构造器，方法，属性
     *       ioc容器中的组件，容器启动会调用无参构造创建对象，在进行初始化操作
     *       构造器，方法，属性要用的组件也是从容器中
     *       构造器上 如果组件只有一个有参数构造器，可以省略autowired  参数位置还是可以从容器中取
     */
    @Primary
    @Bean("nameDao2")
    public NameDao nameDao(){
        NameDao nameDao = new NameDao();
        nameDao.setLabel("2");
        return nameDao;
    }

}
