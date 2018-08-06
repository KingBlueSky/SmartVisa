package com.smart.visa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.smart.visa.app.dao")
public class SmartVisaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartVisaApplication.class, args);
    }
}
