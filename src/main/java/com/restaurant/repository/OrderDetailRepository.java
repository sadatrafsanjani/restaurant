package com.restaurant.repository;

import com.restaurant.model.OrderDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query("SELECT OD FROM OrderDetail OD WHERE OD.order.id = :orderId")
    List<OrderDetail> findAllByOrderId(Long orderId);
}
