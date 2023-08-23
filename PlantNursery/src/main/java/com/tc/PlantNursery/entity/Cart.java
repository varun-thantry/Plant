package com.tc.PlantNursery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Cart")
@DynamicInsert
@DynamicUpdate
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @OneToOne
    @JoinColumn(name="uid")
    private User user;

    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

}
