package com.webFlux.webflux.demo.traditional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraditionalController {

    @GetMapping("/normalApi")
    public String getTraditionalData() {
        return "Test Response of a traditional API";
    }
}
