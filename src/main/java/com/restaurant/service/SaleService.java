package com.restaurant.service;

import com.restaurant.dto.projection.SaleProjection;
import com.restaurant.dto.response.SaleResponse;
import com.restaurant.model.Sale;
import com.restaurant.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public BigDecimal totalSaleAmountOfCurrentDate(){

        return saleRepository.getTotalSaleAmountOfCurrentDate(LocalDate.now());
    }

    public List<SaleProjection> getMaxSaleDay(String startDate, String endDate){

        LocalDate from = LocalDate.parse(startDate);
        LocalDate to = LocalDate.parse(endDate);

        return saleRepository.getMaxSaleDay(from, to);
    }
}
