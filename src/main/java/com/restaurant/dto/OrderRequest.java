package com.restaurant.dto;

import com.restaurant.model.Customer;
import com.restaurant.model.Food;
import com.restaurant.model.Order;
import com.restaurant.model.OrderDetail;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderRequest {

    private Long userId;
    private Map<String, Integer> orders = new HashMap<>();

    public static Order toMODEL(Customer customer){

        return Order.builder()
                .customer(customer)
                .orderedOn(LocalDate.now())
                .build();
    }

    public static OrderDetail toMODEL(Order order, Food food, int quantity, BigDecimal unitPrice, BigDecimal total){

        return OrderDetail.builder()
                .order(order)
                .food(food)
                .quantity(quantity)
                .unitPrice(unitPrice)
                .total(total)
                .build();
    }
}
