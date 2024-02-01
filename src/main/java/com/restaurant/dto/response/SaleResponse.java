package com.restaurant.dto.response;

import com.restaurant.model.Sale;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SaleResponse {

    private Long orderId;
    private LocalDate soldOn;
    private BigDecimal totalAmount;

    public static SaleResponse toDTO(Sale sale){

        return SaleResponse.builder()
                .orderId(sale.getOrder().getId())
                .totalAmount(sale.getTotalAmount())
                .soldOn(sale.getSoldOn())
                .build();
    }
}
