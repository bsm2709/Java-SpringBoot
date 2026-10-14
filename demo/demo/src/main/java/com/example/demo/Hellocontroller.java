package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @GetMapping("Hello")
    public String Hello(){
        return "<h1>Hello world</h1>";
    }
}
