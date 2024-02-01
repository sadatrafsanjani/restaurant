package com.restaurant.dto.projection;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface SaleProjection {

    public BigDecimal getSales();
    public LocalDate getDate();

}
