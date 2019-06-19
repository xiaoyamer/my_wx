package com.my.demo1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {


    //@GetMapping("/hello")
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)

    public String a(){

        return "hello git";
    }
}
