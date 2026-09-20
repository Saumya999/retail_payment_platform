package com.thor.dataengineering.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(
    name = "customer",
    schema = "retail"
)
public class CustomerEntity {

    @Id
    @Column(
            name = "customer_id",
            nullable = false,
            updatable = false
    )
    private UUID customerId;

    @Column(
            name = "name",
            nullable = false,
            length = 200
    )
    private String name;

    @Column(
            name = "country",
            nullable = false,
            length = 100
    )
    private String country;

    @Column(
            name = "address",
            nullable = false,
            length = 500
    )
    private String address;

    @Column(
            name = "created_at",
            nullable = false,
            updatable = false
    )
    private OffsetDateTime createdAt;

    protected CustomerEntity() {
        // Required by JPA.
    }

    public CustomerEntity(
            UUID customerId,
            String name,
            String country,
            String address,
            OffsetDateTime createdAt
    ) {
        this.customerId = customerId;
        this.name = name;
        this.country = country;
        this.address = address;
        this.createdAt = createdAt;
    }

}

