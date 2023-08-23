package com.tc.PlantNursery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Query")
@DynamicInsert
@DynamicUpdate
public class Query {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qid;

    @ManyToOne
    @JoinColumn(name = "uid")   // user id of role customer
    private User user;

    private String queryDesc;

    private Boolean queryStatus;

    private String queryAnswer;


}
