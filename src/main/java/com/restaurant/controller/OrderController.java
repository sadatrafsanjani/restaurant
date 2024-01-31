package com.restaurant.controller;

import com.restaurant.dto.OrderRequest;
import com.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request){

        try{

            orderService.createOrder(request);

            return new ResponseEntity<>("Order created!", HttpStatus.CREATED);
        }
        catch (Exception e){

            log.error("{}", e.getMessage());

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getAllOrdersOfCustomer(@PathVariable("customerId") Long customerId){

        return new ResponseEntity<>(orderService.getAllOrdersOfCustomer(customerId), HttpStatus.OK);
    }

    @GetMapping("/today")
    public ResponseEntity<?> getAllOrdersOfToday(){

        return new ResponseEntity<>(orderService.getAllOrdersOfCurrentDay(), HttpStatus.OK);
    }
}
