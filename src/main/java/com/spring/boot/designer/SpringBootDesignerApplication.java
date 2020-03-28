package com.spring.boot.designer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.spring.boot.designer.dao.mapper")
@SpringBootApplication
public class SpringBootDesignerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDesignerApplication.class, args);
    }

}
