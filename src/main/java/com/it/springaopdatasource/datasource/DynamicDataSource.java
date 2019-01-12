package com.it.springaopdatasource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author limeng
 * @date 2019/1/12 14:05
 *
 * 动态数据源编写
 * 需要继承AbstractRoutingDataSource类
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger log = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源为----------------", DataSourceContextHolder.getDB());

        return DataSourceContextHolder.getDB();
    }


}
