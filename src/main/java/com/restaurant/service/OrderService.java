package com.restaurant.service;

import com.restaurant.dto.OrderDetailResponse;
import com.restaurant.dto.OrderRequest;
import com.restaurant.dto.OrderResponse;
import com.restaurant.model.*;
import com.restaurant.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final FoodRepository foodRepository;
    private final SaleRepository saleRepository;

    public void createOrder(OrderRequest request){

        Customer customer = customerRepository.findCustomerById(request.getUserId());
        Map<String, Integer> orders = request.getOrders();
        List<OrderDetail> orderDetails = new ArrayList<>();

        if(!orders.isEmpty()){

            BigDecimal totalAmount = BigDecimal.ZERO;

            Order order = orderRepository.save(OrderRequest.toMODEL(customer));

            for(String foodId : orders.keySet()){

                Food food = foodRepository.getFoodById(Long.valueOf(foodId));
                int quantity = orders.get(foodId);
                BigDecimal unitPrice = food.getPrice();
                BigDecimal total = unitPrice.multiply(BigDecimal.valueOf(quantity));
                orderDetails.add(OrderRequest.toMODEL(order, food, quantity, unitPrice, total));

                totalAmount = totalAmount.add(total);
            }

            orderDetailRepository.saveAll(orderDetails);

            Sale sale = Sale.builder()
                    .order(order)
                    .totalAmount(totalAmount)
                    .soldOn(LocalDate.now())
                    .build();

            saleRepository.save(sale);
        }
    }

    public List<OrderResponse> getAllOrdersOfCustomer(Long customerId){

        List<OrderResponse> responses = new ArrayList<>();
        List<Order> orders = orderRepository.findAllByCustomerId(customerId);

        if(!orders.isEmpty()){

            orders.forEach(order -> {

                List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrderId(order.getId());
                List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
                BigDecimal totalAmount = BigDecimal.ZERO;

                if(!orderDetails.isEmpty()){

                    for(OrderDetail orderDetail : orderDetails){

                        totalAmount = totalAmount.add(orderDetail.getTotal());
                        orderDetailResponses.add(OrderDetailResponse.toDTO(orderDetail));
                    }

                    responses.add(OrderResponse.toDTO(order, orderDetailResponses, totalAmount));
                }
            });
        }

        return responses;
    }

    public List<OrderResponse> getAllOrdersOfCurrentDay(){

        List<OrderResponse> responses = new ArrayList<>();
        List<Order> orders = orderRepository.findAllOrdersOfToday(LocalDate.now());

        if(!orders.isEmpty()){

            orders.forEach(order -> {

                List<OrderDetail> orderDetails = orderDetailRepository.findAllByOrderId(order.getId());
                List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
                BigDecimal totalAmount = BigDecimal.ZERO;

                if(!orderDetails.isEmpty()){

                    for(OrderDetail orderDetail : orderDetails){

                        totalAmount = totalAmount.add(orderDetail.getTotal());
                        orderDetailResponses.add(OrderDetailResponse.toDTO(orderDetail));
                    }

                    responses.add(OrderResponse.toDTO(order, orderDetailResponses, totalAmount));
                }
            });
        }

        return responses;
    }
}
