package com.lgc.spring.profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 多环境
 * -Dspring.profiles.active=dev
 *
 * @author lgc
 * @create 2020-01-13 11:18 上午
 **/
@PropertySource("classpath:/dataSource.properties")
@Configuration
public class ProfileOfDataSource implements EmbeddedValueResolverAware {

    /**
     *  value 0. 基本树值 1.spel #{} 2.${} 运行环境配置文件中的值
     */
    @Value("${dataSource.user}")
    private String user;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${dataSource.password") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        return mysqlDataSource;
    }


    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

    }
}
