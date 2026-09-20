package com.thor.dataengineering.model;

import java.util.UUID;

public record Customer(
        UUID customerId,
        String name,
        String country,
        String address
) {
}