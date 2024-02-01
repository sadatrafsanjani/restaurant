package com.restaurant.service;

import com.restaurant.dto.response.APIResponse;
import com.restaurant.dto.response.CustomerResponse;
import com.restaurant.model.Customer;
import com.restaurant.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public APIResponse getAllCustomers(){

        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        if(!customers.isEmpty()){

            customers.forEach(customer -> responses.add(CustomerResponse.toDTO(customer)));
        }

        return APIResponse.builder()
                .message(responses.size() + " data(s) found!")
                .body(responses)
                .build();
    }
}
