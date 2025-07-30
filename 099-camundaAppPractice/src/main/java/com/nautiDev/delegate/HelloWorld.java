package com.nautiDev.delegate;

import org.springframework.stereotype.Service;

@Service("helloSpring")
public class HelloWorld {

    public void helloWorldTask(){
        System.out.println("Hello World form Gmail Service!!");
    }
}
