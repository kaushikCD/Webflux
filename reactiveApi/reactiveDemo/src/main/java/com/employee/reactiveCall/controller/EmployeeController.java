package com.employee.reactiveCall.controller;

import com.employee.reactiveCall.entity.Employee;
import com.employee.reactiveCall.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}