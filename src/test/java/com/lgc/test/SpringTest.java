package com.lgc.test;
import com.lgc.spring.*;
import com.lgc.spring.autoconfig.SpringAutoConfig;
import com.lgc.spring.autoconfig.service.NameService;
import com.lgc.spring.autoconfig.web.NameController;
import com.lgc.spring.profile.ProfileOfDataSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lgc
 * @create 2020-01-13 9:37 上午
 **/
public class SpringTest {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testCondition() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("spring ioc 容器启动");
        System.out.println("===== out springIoc beanDefinitionNames start");
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("===== out springIoc beanDefinitionNames end");
//        System.out.println(annotationConfigApplicationContext.getEnvironment().getProperty("os.name"));
        annotationConfigApplicationContext.close();
        System.out.println("spring ioc 容器关闭");
    }

    @Test
    public void testProfile() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getEnvironment().setActiveProfiles("dev");
        annotationConfigApplicationContext.register(ProfileOfDataSource.class);
        annotationConfigApplicationContext.refresh();
        System.out.println("spring ioc 容器启动");
        System.out.println("===== out springIoc beanDefinitionNames start");
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        System.out.println("===== out springIoc beanDefinitionNames end");

    }

    @Test
    public void testAutoConfig(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAutoConfig.class);
        NameController nameController = applicationContext.getBean(NameController.class);
        System.out.println(nameController);
        NameService nameService = applicationContext.getBean(NameService.class);
        System.out.println(nameService);
        applicationContext.close();

    }

}
