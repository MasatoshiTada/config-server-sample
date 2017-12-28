package com.example.sampleservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class GreetingController {

    private String greeting;

    public GreetingController(@Value("${greeting}") String greeting) {
        this.greeting = greeting;
    }

    @GetMapping("/")
    public String greet() {
        return greeting;
    }
}