package com.restaurant.dto.response;

import com.restaurant.model.OrderDetail;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderDetailResponse {

    private String food;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public static OrderDetailResponse toDTO(OrderDetail orderDetail){

        return OrderDetailResponse.builder()
                .food(orderDetail.getFood().getTitle())
                .quantity(orderDetail.getQuantity())
                .unitPrice(orderDetail.getUnitPrice())
                .total(orderDetail.getTotal())
                .build();
    }
}
