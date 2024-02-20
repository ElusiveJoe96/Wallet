package com.example.wallet;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {
    @Bean
    public SpringLiquibase liquibase(DataSource dataSource, ResourceLoader resourceLoader) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/changelog/changelog-master.xml");
        liquibase.setDataSource(dataSource);

        liquibase.setResourceLoader(resourceLoader);
        liquibase.setChangeLog("classpath:db/changelog/changelog-master.xml");
        liquibase.setContexts("development,test,production");
        liquibase.setShouldRun(true);

        return liquibase;
    }
}