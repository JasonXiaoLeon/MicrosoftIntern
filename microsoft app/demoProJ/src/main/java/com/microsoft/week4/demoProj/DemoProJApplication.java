package com.microsoft.week4.demoProj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.microsoft.week4.demoProj.Mapper")
public class DemoProJApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProJApplication.class, args);
    }

}
