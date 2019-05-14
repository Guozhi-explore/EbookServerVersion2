package com.example.servlet.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/5/14
 * @description:
 **/
@RestController
public class TestController {
    @RequestMapping(value = "/hello")
    public String hello()
    {
        return "hello";
    }
}
