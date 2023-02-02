package com.example.learn;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.example.learn.repo.mapper"})
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class ShiroLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroLearnApplication.class, args);
    }

}
