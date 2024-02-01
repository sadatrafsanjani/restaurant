package com.restaurant.service;

import com.restaurant.dto.projection.SaleProjection;
import com.restaurant.dto.response.APIResponse;
import com.restaurant.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public APIResponse totalSaleAmountOfCurrentDate(){

        BigDecimal amount = saleRepository.getTotalSaleAmountOfCurrentDate(LocalDate.now());

        return APIResponse.builder()
                .body(amount)
                .build();
    }

    public APIResponse getMaxSaleDay(String startDate, String endDate){

        LocalDate from = LocalDate.parse(startDate);
        LocalDate to = LocalDate.parse(endDate);

        List<SaleProjection> sales = saleRepository.getMaxSaleDay(from, to);

        return APIResponse.builder()
                .message(sales.size() + " data(s) found!")
                .body(sales)
                .build();
    }
}
