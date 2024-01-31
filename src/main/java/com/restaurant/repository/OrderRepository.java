package com.restaurant.repository;

import com.restaurant.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT O FROM Order O WHERE O.customer.id = :customerId")
    List<Order> findAllByCustomerId(Long customerId);

    @Query("SELECT O FROM Order O WHERE O.orderedOn = :localDate")
    List<Order> findAllOrdersOfToday(LocalDate localDate);
}
