package com.neoteric.config;

import com.neoteric.dao.StudentMarksDAo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration


public class AppConfig {

        @Bean
        public DataSource dataSource() {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl("jdbc:mysql://localhost:3306/studentschema");
            config.setUsername("root");  // Replace with your DB username
            config.setPassword("Cherukuri@19");  // Replace with your DB password
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");

            // Optional Hikari settings
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(2);
            config.setIdleTimeout(30000);
            config.setConnectionTimeout(30000);
            config.setLeakDetectionThreshold(2000);

            return new HikariDataSource(config);
        }

        @Bean
        public StudentMarksDAo studentMarkDAO() {
            StudentMarksDAo dao = new StudentMarksDAo();
            dao.setDataSource(dataSource());
            return dao;
        }
    }

