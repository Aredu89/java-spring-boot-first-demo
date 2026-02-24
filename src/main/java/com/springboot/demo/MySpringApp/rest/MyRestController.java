package com.springboot.demo.MySpringApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @Value("${team.name}")
    private String teamName;
    // add code to expose "/" that return "Hello World"

    @GetMapping("/")
     public String sayHello() {
         return "Hello World. Team Name: " + teamName;
     }
}
