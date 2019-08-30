# Write your MySQL query statement below

SELECT
    ROUND(SUM(IF(b.order_date = b.customer_pref_delivery_date, 1, 0)) / COUNT(DISTINCT a.customer_id) * 100, 2) immediate_percentage
FROM (
    SELECT customer_id, MIN(order_date) earliest_date
    FROM Delivery
    GROUP BY customer_id
) a
LEFT JOIN Delivery b
ON a.customer_id = b.customer_id AND a.earliest_date = b.order_date
