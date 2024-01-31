package com.restaurant.dto;

import com.restaurant.model.Customer;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private Long id;
    private String customerName;

    public static CustomerResponse toDTO(Customer customer){

        return CustomerResponse.builder()
                .id(customer.getId())
                .customerName(customer.getCustomerName())
                .build();
    }
}
