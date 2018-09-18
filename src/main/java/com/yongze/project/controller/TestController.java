package com.yongze.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/d")
    public String d() {
        System.out.println("ddd");
        return "test";
    }
}
