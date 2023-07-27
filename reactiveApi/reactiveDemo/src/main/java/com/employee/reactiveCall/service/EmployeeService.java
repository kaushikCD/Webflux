package com.employee.reactiveCall.service;

import com.employee.reactiveCall.entity.Employee;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    private final Flux<Employee> employees;

    public EmployeeService() {
        employees = Flux.just(
                new Employee(100, "Arjun", 22),
                new Employee(101, "Kumar", 21)
        );
    }
    public Flux<Employee> getAllEmployees() {
        return employees;
    }
    }
