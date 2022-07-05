package com.dailycodebuffer.springboot.tutorial.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/rain")
    public String helloWorld(){
        return "let's see the use of mapper";
    }
}
