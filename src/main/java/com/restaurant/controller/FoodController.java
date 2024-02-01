package com.restaurant.controller;

import com.restaurant.dto.request.FoodRequest;
import com.restaurant.dto.response.APIResponse;
import com.restaurant.service.FoodService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<?> createFood(@RequestBody FoodRequest request){

        try{

            return new ResponseEntity<>(foodService.createFood(request), HttpStatus.CREATED);
        }
        catch (Exception e){

            log.error("{}", e.getMessage());

            APIResponse response = APIResponse.builder()
                    .message(e.getMessage())
                    .build();

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
