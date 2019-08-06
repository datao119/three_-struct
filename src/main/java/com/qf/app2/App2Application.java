package com.qf.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.qf.app2.mapper"})
@EnableScheduling
@EnableAsync
public class App2Application{

    public static void main(String[] args) {
        SpringApplication.run(App2Application.class, args);
    }

}
