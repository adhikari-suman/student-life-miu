-- ===============================
-- Task 5 - Query 1
-- ===============================

-- Display the list of ALL the Accounts registered in the banking system, sorted in
-- descending order of the Account Balances. Include the Customer data for each
-- Account.
SELECT
    a.account_number,
    a.balance,
    a.date_opened,
    a.status,
    ac.account_type_name,
    c.first_name,
    c.last_name,
    c.telephone_number
FROM Account a
    INNER JOIN Customer_Account ca
        ON a.account_id = ca.account_id
    INNER JOIN Customer c
        ON ca.customer_id = c.customer_id
    INNER JOIN AccountType ac ON a.account_type_id = ac.account_type_id
ORDER BY a.balance DESC;


-- ===============================
-- Task 5 - Query 2
-- ===============================
-- Display the list of ALL Transactions with a Value Amount greater than 500.00.
-- Include in the result, the Account Numbers. And sort the list in ascending order
-- of the Tansaction Date and Time.
SELECT
    t.transaction_date,
    t.transaction_time,
    t.transaction_number,
    a.account_number,
    t.value_amount,
    t.transaction_type
FROM Transaction t
    INNER JOIN Account a
        ON t.account_id = a.account_id
WHERE
    t.value_amount > 500.00
ORDER BY
    t.transaction_date,
    t.transaction_time;