package com.nautiDev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //http://localhost:8080/test
    @GetMapping("/test")
    public String HelloHome(){
        return "Hello Akshit";
    }
}
