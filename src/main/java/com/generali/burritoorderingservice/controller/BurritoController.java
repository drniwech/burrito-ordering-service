package com.generali.burritoorderingservice.controller;

import com.generali.burritoorderingservice.dao.OrderRepository;
import com.generali.burritoorderingservice.exceptions.OrderNotFoundException;
import com.generali.burritoorderingservice.model.TheOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BurritoController {

    @Autowired
    private OrderRepository repository; //TODO: we can add service layer

    @GetMapping("/orders/{orderId}")
    TheOrder getOrdersByOrderId(@PathVariable Long orderId){
        return repository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @PostMapping("/orders")
    TheOrder newOrder(@RequestBody TheOrder order) {
        return repository.save(order);
    }
}
