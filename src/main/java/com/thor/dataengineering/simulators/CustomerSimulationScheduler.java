package com.thor.dataengineering.simulators;

import com.thor.dataengineering.config.SimulatorProperties;
import com.thor.dataengineering.generator.customer.CustomerGenerator;
import com.thor.dataengineering.model.Customer;
import com.thor.dataengineering.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Component
@Slf4j
@ConditionalOnProperty(
        prefix = "simulator.customer",
        name = "enabled",
        havingValue = "true"
)
public class CustomerSimulationScheduler {

    private final CustomerGenerator customerGenerator;

    private final CustomerService customerService;

    private final SimulatorProperties properties;

    public CustomerSimulationScheduler(
            CustomerGenerator customerGenerator,
            CustomerService customerService,
            SimulatorProperties properties
    ) {
        this.customerGenerator = customerGenerator;
        this.customerService = customerService;
        this.properties = properties;
    }

    @Scheduled(initialDelay = 0, fixedRate = 5 * 60 * 1000L)
    public void generateCustomers() {
        log.info("Generating customers at :{}", LocalDateTime.now());
        List<Customer> customers =
                IntStream.range(
                                0,
                                properties.batchSize()
                        )
                        .mapToObj(
                                ignored ->
                                        customerGenerator.generate()
                        )
                        .toList();

        customerService.createCustomers(customers);
    }
}
