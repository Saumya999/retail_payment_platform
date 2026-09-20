package com.thor.dataengineering.utility;

public record CountryDistribution(
        String country,
        int cumulativeWeight
) {
}