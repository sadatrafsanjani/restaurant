package com.restaurant.dto;

import lombok.Builder;

@Builder
public class APIResponse {

    private String message;
    private Object body;
}
