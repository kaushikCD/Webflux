package com.ApiCall.reactive.controller;

import com.employee.reactiveCall.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@RestController
public class CallController {
    private final WebClient webClient;
    public CallController() {
        this.webClient = WebClient.create("http://localhost:8081");
    }
    @GetMapping("/api")
    public String getEmployees() {
        webClient.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class)
                .delayElements(Duration.ofMillis(3000))
                .subscribe(this::handleData);

        return "Data is being consumed...";
    }
    private void handleData(Employee employee) {
        System.out.println("Received Employee: " + employee);
    }
}