package com.restaurant.service;

import com.restaurant.dto.SaleResponse;
import com.restaurant.model.Sale;
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

    public BigDecimal totalSaleAmountOfCurrentDate(){

        return saleRepository.getTotalSaleAmountOfCurrentDate(LocalDate.now());
    }

    public SaleResponse getMaxSaleDay(LocalDate from , LocalDate to){

        List<Sale> sales =  saleRepository.getMaxSaleDay(from, to);

        return null;
    }
}
