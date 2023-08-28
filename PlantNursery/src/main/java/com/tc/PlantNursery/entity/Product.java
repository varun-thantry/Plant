package com.tc.PlantNursery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String imageUrl;

    private Double price;

    private Boolean stockStatus;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    private Double rating;






}
