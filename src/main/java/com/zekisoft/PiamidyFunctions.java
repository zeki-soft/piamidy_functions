package com.zekisoft;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class PiamidyFunctions {

    public static void main(String... args) {
        SpringApplication.run(PiamidyFunctions.class, args);
    }

    @Bean
    public Supplier<Mono<String>> hello() {
        return () -> Mono.just("Hello Spring PiamidyFunctions!!!!");
    }
	
    @Bean
    public Supplier<Mono<String>> hello2() {
        return () -> Mono.just("Hello Spring PiamidyFunctions2!!!!");
    }
	
    @Bean
    public Function<Mono<String>, Mono<String>> decorate() {
        return message -> message.map(m -> String.format("★★★%s★★★", m));
    }

    @Bean
    public Consumer<Flux<String>> consume() {
        return message -> message.subscribe(m -> System.out.printf("Received: %s%n", m));
    }
}