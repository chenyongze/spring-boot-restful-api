package com.yongze.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 基础项目框架
 * @author YI
 * @date 2018-6-27 16:46:15
 */
@MapperScan({"com.yongze.project.dao"})
@SpringBootApplication
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}
