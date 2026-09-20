CREATE SCHEMA IF NOT EXISTS retail;

CREATE TABLE retail.customer
(
    customer_id UUID PRIMARY KEY,

    name VARCHAR(200) NOT NULL,

    country VARCHAR(100) NOT NULL,

    address VARCHAR(500) NOT NULL,

    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_customer_country
    ON retail.customer(country);

CREATE INDEX idx_customer_created_at
    ON retail.customer(created_at);