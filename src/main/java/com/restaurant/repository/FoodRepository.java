package com.restaurant.repository;

import com.restaurant.model.Food;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    @Query("SELECT F FROM Food F WHERE F.id = :id")
    Food getFoodById(Long id);
}
