package com.yi.project.controller;


import com.yi.project.bean.FestFulBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method= RequestMethod.GET)
    public FestFulBean<String> user(@RequestParam String username) {
        FestFulBean<String> restful = new FestFulBean<String>();
        restful.setData("hello, " + username + " welcom to my website!");
        restful.setStatus(0);
        restful.setMsg("成功");
        return restful;
    }
}
