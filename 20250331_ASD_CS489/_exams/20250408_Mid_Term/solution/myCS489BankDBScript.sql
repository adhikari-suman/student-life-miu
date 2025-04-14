-- ===============================
-- CS489 Bank - Retail Banking DDL
-- ===============================

-- Customer Table
CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    telephone_number VARCHAR(20)
);

-- AccountType Table
CREATE TABLE AccountType (
    account_type_id INT PRIMARY KEY,
    account_type_name VARCHAR(100) NOT NULL
);

-- Account Table
CREATE TABLE Account (
    account_id BIGINT PRIMARY KEY,
    account_number VARCHAR(50) NOT NULL UNIQUE,
    date_opened DATE NOT NULL,
    status VARCHAR(50) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    account_type_id INT NOT NULL,
    FOREIGN KEY (account_type_id) REFERENCES AccountType(account_type_id)
);

-- Transaction Table
CREATE TABLE Transaction (
    transaction_id BIGINT PRIMARY KEY,
    transaction_number VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL,
    value_amount DECIMAL(15, 2) NOT NULL,
    transaction_date DATE NOT NULL,
    transaction_time TIME NOT NULL,
    transaction_type VARCHAR(50),
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);

-- Join Table for Many-to-Many between Customer and Account
CREATE TABLE Customer_Account (
    customer_id INT NOT NULL,
    account_id BIGINT NOT NULL,
    PRIMARY KEY (customer_id, account_id),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (account_id) REFERENCES Account(account_id)
);