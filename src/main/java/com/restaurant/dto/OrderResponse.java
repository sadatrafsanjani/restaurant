package com.restaurant.dto;

import com.restaurant.model.Order;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    private Long orderId;
    private String customerName;
    private LocalDate orderedOn;
    private List<OrderDetailResponse> orderDetails;
    private BigDecimal totalAmount;

    public static OrderResponse toDTO(Order order, List<OrderDetailResponse> orderDetailResponses, BigDecimal totalAmount){

        return OrderResponse.builder()
                .customerName(order.getCustomer().getCustomerName())
                .orderId(order.getId())
                .orderDetails(orderDetailResponses)
                .totalAmount(totalAmount)
                .orderedOn(order.getOrderedOn())
                .build();
    }
}
