package com.restaurant.controller;

import com.restaurant.dto.request.OrderRequest;
import com.restaurant.dto.response.APIResponse;
import com.restaurant.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request){

        try{

            return new ResponseEntity<>(orderService.createOrder(request), HttpStatus.CREATED);
        }
        catch (Exception e){

            log.error("{}", e.getMessage());

            APIResponse response = APIResponse.builder()
                    .message(e.getMessage())
                    .body(new ArrayList<>())
                    .build();

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
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
