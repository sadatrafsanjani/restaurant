package com.restaurant.dto.response;

import com.restaurant.model.Food;
import lombok.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodResponse {

    private String title;
    private BigDecimal price;

    public static FoodResponse toDTO(Food food){

        return FoodResponse.builder()
                .title(food.getTitle())
                .price(food.getPrice())
                .build();
    }
}
