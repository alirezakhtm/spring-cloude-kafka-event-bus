package com.khtm.demo.accountservice;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AccountConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(dataSource);
        springLiquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        return springLiquibase;
    }


}
