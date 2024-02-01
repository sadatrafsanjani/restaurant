package com.restaurant.dto.response;

import lombok.Builder;

@Builder
public class APIResponse {

    private String message;
    private Object body;
}
