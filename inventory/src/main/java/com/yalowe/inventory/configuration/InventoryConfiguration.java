package com.yalowe.inventory.configuration;

import com.yalowe.inventory.beans.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration

public class InventoryConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String dbFilePath = getClass().getClassLoader().getResource("sql").getPath();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("mysqluser");
        dataSource.setPassword("mysqlpass");
        if (dbFilePath != null) {
            dbFilePath += "/data.sql";
            dataSource.setUrl("jdbc:h2:file:" + dbFilePath);
        } else {
            dataSource.setUrl("jdbc:h2:file:/data/sample");
        }

        return dataSource;
    }


}
