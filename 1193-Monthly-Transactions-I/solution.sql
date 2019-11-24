# Write your MySQL query statement below

SELECT
    LEFT(trans_date, 7) month,
    country,
    COUNT(1) trans_count,
    SUM(IF(state='approved', 1, 0)) approved_count,
    SUM(amount) trans_total_amount,
    SUM(IF(state='approved', amount, 0)) approved_total_amount
FROM Transactions
GROUP BY month, country