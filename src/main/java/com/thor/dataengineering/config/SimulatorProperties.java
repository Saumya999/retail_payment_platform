package com.thor.dataengineering.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "simulator.customer")
public record SimulatorProperties(

        int batchSize,

        long fixedDelayMs

) {
}