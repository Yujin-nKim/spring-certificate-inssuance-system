package com.nhnacademy.springcertificateinssuancesystem.config;

import com.nhnacademy.springcertificateinssuancesystem.Base;
import com.nhnacademy.springcertificateinssuancesystem.properties.DatabaseProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@RequiredArgsConstructor
@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = @ComponentScan.Filter(Controller.class))
public class RootConfig {

    private final DatabaseProperties databaseProperties;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(databaseProperties.getDriverClassName());
        basicDataSource.setUrl(databaseProperties.getUrl());
        basicDataSource.setUsername(databaseProperties.getUsername());
        basicDataSource.setPassword(databaseProperties.getPassword());
        basicDataSource.setInitialSize(databaseProperties.getInitialSize());
        basicDataSource.setMaxTotal(databaseProperties.getMaxTotal());
        basicDataSource.setMinIdle(databaseProperties.getMinIdle());
        basicDataSource.setMaxIdle(databaseProperties.getMaxIdle());
        basicDataSource.setTestOnBorrow(databaseProperties.isTestOnBorrow());
        if(databaseProperties.isTestOnBorrow()) {
            basicDataSource.setValidationQuery(basicDataSource.getValidationQuery());
        }
        return basicDataSource;
    }

}

