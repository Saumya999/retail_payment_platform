package com.thor.dataengineering.service;

import com.thor.dataengineering.entity.CustomerEntity;
import com.thor.dataengineering.model.Customer;
import com.thor.dataengineering.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(
            CustomerRepository customerRepository
    ) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void createCustomers(
            List<Customer> customers
    ) {

        OffsetDateTime createdAt =
                OffsetDateTime.now();

        List<CustomerEntity> entities =
                customers.stream()
                        .map(customer ->
                                new CustomerEntity(
                                        customer.customerId(),
                                        customer.name(),
                                        customer.country(),
                                        customer.address(),
                                        createdAt
                                )
                        )
                        .toList();

        customerRepository.saveAll(entities);
    }
}
