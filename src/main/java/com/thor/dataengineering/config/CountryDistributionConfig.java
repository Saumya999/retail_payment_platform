package com.thor.dataengineering.config;

import com.thor.dataengineering.utility.CountryDistribution;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CountryDistributionConfig {

    @Bean
    public List<CountryDistribution> countryDistribution() {

        return List.of(
                new CountryDistribution("USA", 30),
                new CountryDistribution("IN", 45),
                new CountryDistribution("UK", 55),
                new CountryDistribution("DE", 63),
                new CountryDistribution("FR", 70),
                new CountryDistribution("JP", 77),
                new CountryDistribution("SI", 82),
                new CountryDistribution("SA", 87),
                new CountryDistribution("NI", 92),
                new CountryDistribution("KE", 95),
                new CountryDistribution("UAE", 98),
                new CountryDistribution("AU", 100)
        );
    }
}