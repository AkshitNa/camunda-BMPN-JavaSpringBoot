package com.nautiDev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //localhost:8080/helloCamunda
    @GetMapping("/helloCamunda")
    public String helloCamunda(){
        return "Hello Camunda 7";
    }
}
