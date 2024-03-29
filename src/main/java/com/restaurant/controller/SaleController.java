package com.restaurant.controller;

import com.restaurant.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping("/current-date-sale-amount")
    public ResponseEntity<?> getTotalSaleAmountOfCurrentDate(){

        return new ResponseEntity<>(saleService.totalSaleAmountOfCurrentDate(), HttpStatus.OK);
    }

    @GetMapping("/max-sale-day")
    public ResponseEntity<?> getMaxSaleDay(@RequestParam("from") String from, @RequestParam("to") String to){

        return new ResponseEntity<>(saleService.getMaxSaleDay(from, to), HttpStatus.OK);
    }
}
