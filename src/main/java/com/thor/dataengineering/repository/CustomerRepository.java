package com.thor.dataengineering.repository;

import com.thor.dataengineering.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository
        extends JpaRepository<CustomerEntity, UUID> {

    List<CustomerEntity> findByCountryOrderByCreatedAtDesc(
            String country
    );
}
