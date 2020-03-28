package com.baker.learning.learnmultipledb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.baker.learning.learnmultipledb.mapper")
@ComponentScan("com.baker.learning.learnmultipledb")
public class LearnMultipleDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMultipleDbApplication.class, args);
    }

}
