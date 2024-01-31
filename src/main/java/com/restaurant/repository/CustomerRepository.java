package com.restaurant.repository;

import com.restaurant.model.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT C FROM Customer C WHERE C.id = :id")
    Customer findCustomerById(Long id);
}
