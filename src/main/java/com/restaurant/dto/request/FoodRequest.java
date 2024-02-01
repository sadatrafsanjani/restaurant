package com.restaurant.dto.request;

import com.restaurant.model.Food;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodRequest {

    private String title;
    private double price;

    public static Food toMODEL(FoodRequest request){

        return Food.builder()
                .title(request.getTitle())
                .price(BigDecimal.valueOf(request.getPrice()))
                .build();
    }
}
