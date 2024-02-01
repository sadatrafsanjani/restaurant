package com.restaurant.service;

import com.restaurant.dto.request.FoodRequest;
import com.restaurant.dto.response.FoodResponse;
import com.restaurant.dto.response.APIResponse;
import com.restaurant.model.Food;
import com.restaurant.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public APIResponse createFood(FoodRequest request){

        Food food = foodRepository.save(FoodRequest.toMODEL(request));

        return APIResponse.builder()
                .message("Food created!")
                .body(FoodResponse.toDTO(food))
                .build();
    }
}
