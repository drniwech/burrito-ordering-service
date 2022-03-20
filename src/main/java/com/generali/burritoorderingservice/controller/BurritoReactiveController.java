package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.dao.OrderRepository;
import com.generali.burritoorderingservice.model.TheOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BurritoReactiveController {

    @Autowired
    private OrderRepository repository; //TODO: we can add service layer

    @Autowired
    private WebClient webClient;

    @Value("${base.url:http://localhost:8080}")
    private String baseUrl;

    //Reactive
    @GetMapping("/reactive/all")
    private Flux<TheOrder> getAllOrders() {
        return Flux.fromIterable(repository.findAll());
    }

    //Reactive
    @GetMapping("/reactive/orders/{orderId}")
    Mono<TheOrder> getReactiveOrderById(@PathVariable Long orderId) {
        Mono<TheOrder> order = webClient.get()
                //calling our REST endpoint at BurritoController
                .uri(this.baseUrl+"/orders/{orderId}", orderId)
                .retrieve()
                .bodyToMono(TheOrder.class);
        return order;
    }

    @PostMapping("/reactive/orders/add")
    Mono<TheOrder> addOrder(TheOrder order){
        return webClient.post()
                .uri("/orders")
                .body(Mono.just(order), TheOrder.class)
                .retrieve()
                .bodyToMono(TheOrder.class);
    }

}
