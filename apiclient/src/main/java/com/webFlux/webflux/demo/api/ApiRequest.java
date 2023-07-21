
package com.webFlux.webflux.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ApiRequest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting a WebFlux API call");
        CompletableFuture<String> reactiveResults =reactiveEndpoint();
        traditionalEndpoint();
        System.out.println("Reactive API response: "+ reactiveResults.get());
    }
    private static void traditionalEndpoint() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> traditionalResponse = template.getForEntity("http://localhost:8081/normalApi", String.class);
        String result = traditionalResponse.getBody();
        System.out.println("Normal API Response: " + result);
    }
    private static CompletableFuture<String> reactiveEndpoint() {
        WebClient clientCall = WebClient.create("http://localhost:8080");
        return clientCall.get()
                .uri("/monoReactive")
                .retrieve()
                .bodyToMono(String.class)
                .delaySubscription(Duration.ofSeconds(3))
                .toFuture();
    }


}









