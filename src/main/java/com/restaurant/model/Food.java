package com.restaurant.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "foods")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private BigDecimal price;
}
