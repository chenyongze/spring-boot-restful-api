package com.yongze.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping(value="/addCity",method= RequestMethod.GET)
    public boolean addCity() {
        System.out.println("开始新增...");
        return true;
    }
}
