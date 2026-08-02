package com.example.Starter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public  String helloWorld(){
        System.out.println("Request called");
        return "Hello World";
    }

}
