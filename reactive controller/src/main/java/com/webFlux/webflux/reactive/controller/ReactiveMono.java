package com.webFlux.webflux.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
public class ReactiveMono {

    @GetMapping("/monoReactive")
    public Mono<String> testMono() {
        return Mono.just("Test Response of a reactive API");
    }
}





