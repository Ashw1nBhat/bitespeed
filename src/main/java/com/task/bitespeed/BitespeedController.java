package com.task.bitespeed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitespeedController {
    @RequestMapping
    public String HelloWorld(){
        return "Hello World";
    }
}