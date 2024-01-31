package com.restaurant.repository;

import com.restaurant.model.Sale;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT SUM(S.totalAmount) FROM Sale S WHERE S.soldOn = :localDate")
    BigDecimal getTotalSaleAmountOfCurrentDate(LocalDate localDate);

    @Query("SELECT MAX(S.totalAmount) FROM Sale S WHERE S.soldOn >= :from AND S.soldOn <= :to ")
    List<Sale> getMaxSaleDay(LocalDate from, LocalDate to);
}
