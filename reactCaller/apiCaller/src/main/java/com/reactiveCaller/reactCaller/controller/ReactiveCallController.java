package com.reactiveCaller.reactCaller.controller;

import com.employee.reactiveCall.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
public class ReactiveCallController {
    private final WebClient webClient;
    public ReactiveCallController() {
        this.webClient = WebClient.create("http://localhost:8081");
    }
    @GetMapping("/api")
    public Flux<Employee> getEmployees() {
        return webClient.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(Employee.class);
    }
}