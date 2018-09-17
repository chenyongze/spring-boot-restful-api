package com.yi.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 基础项目框架
 * @author YI
 * @date 2018-6-27 16:46:15
 */
@MapperScan({"com.yi.project.dao"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
