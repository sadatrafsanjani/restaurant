package com.restaurant.dto.projection;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface SaleProjection {

    public LocalDate getSoldOn();
    public BigDecimal getTotalAmount();
}
