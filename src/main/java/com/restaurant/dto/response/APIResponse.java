package com.restaurant.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class APIResponse {

    private String message;
    private Object body;
}
