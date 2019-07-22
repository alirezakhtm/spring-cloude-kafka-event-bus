package com.khtm.demo.cifservice;

import liquibase.Liquibase;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.liquibase.LiquibaseEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class CifConfiguration {

    @Autowired
    DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/liquibase-changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
