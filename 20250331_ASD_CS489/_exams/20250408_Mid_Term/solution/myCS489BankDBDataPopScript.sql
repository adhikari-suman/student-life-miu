-- ===============================
-- CS489 Bank - Retail Banking DML
-- ===============================

-- ===================================================
-- Insert AccountType
-- ===================================================
INSERT INTO AccountType (account_type_id, account_type_name) VALUES
(1, 'Checking'),
(2, 'Savings'),
(3, 'Loan');

-- ===================================================
-- Insert Customer
-- ===================================================
INSERT INTO Customer (customer_id, first_name, last_name, telephone_number) VALUES
(1, 'Daniel', 'Agar', NULL),
(2, 'Bernard', 'Shaw', '(641) 472-1234'),
(3, 'Carly', 'DeFiori', NULL);

-- ===================================================
-- Insert Account information
-- ===================================================
INSERT INTO Account (account_id, account_number, date_opened, status, balance, account_type_id) VALUES
(1, 'CK1089', '2021-10-15', 'Active', 105945.50, 2),
(2, 'SV1104', '2019-06-22', 'Active', 197750.00, 1),
(3, 'SV2307', '2014-02-27', 'Dormant', 842000.75, 1),
(4, 'LN4133', '2005-11-07', 'Active', 674500.00, 3);

-- Account 1 belongs to Customer 3
INSERT INTO Customer_Account (customer_id, account_id) VALUES
(3, 1),

-- Account 2 is joint between Customer 1 and Customer 2
(1, 2),
(2, 2),

-- Account 3 belongs to Customer 3
(3, 3),

-- Account 4 belongs to Customer 3
(3, 4);


-- ===================================================
-- Insert Transactions
-- ===================================================
INSERT INTO Transaction (
    transaction_id,
    transaction_number,
    description,
    value_amount,
    transaction_date,
    transaction_time,
    transaction_type,
    account_id
) VALUES
(1, 'D0187-175', 'Deposit to Savings', 100000.00, '2021-10-15', '12:15:00', 'Deposit', 2),
(2, 'W1736-142', 'Teller counter withdrawal', 550.00, '2022-08-24', '10:05:00', 'Withdrawal', 1),
(3, 'DD001-142', 'Direct deposit – wage', 2475.75, '2014-03-01', '05:00:00', 'Direct deposit', 1),
(4, 'P162-0017', 'Merch purchase online', 150.95, '2019-12-15', '14:19:00', 'Purchase', 1);


