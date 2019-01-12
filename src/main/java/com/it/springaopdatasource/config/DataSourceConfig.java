package com.it.springaopdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.it.springaopdatasource.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author limeng
 * @date 2019/1/12 14:01
 *
 * 数据源注册
 */
@Configuration
public class DataSourceConfig {
    @Autowired
    Environment env;
    @Bean(name = "dataSource1")
    public DataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.db1.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.db1.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db1.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.db1.driver-class-name"));
        return dataSource;
    }
    @Bean(name = "dataSource2")
    public DataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.db2.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.db2.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.db2.password"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.db2.driver-class-name"));
        return dataSource;
    }

    @Bean(name = "dynamicDS")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 默认数据源,当没有指定的时候使用，可以当做主数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("dataSource1", dataSource1());
        dsMap.put("dataSource2", dataSource2());

        // 注册多数据源
        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
    }

}