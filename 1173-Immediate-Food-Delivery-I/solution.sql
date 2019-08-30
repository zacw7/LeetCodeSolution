# Write your MySQL query statement below

SELECT ROUND(SUM(IF(order_date = customer_pref_delivery_date, 1, 0)) / SUM(1) * 100, 2) immediate_percentage
FROM Delivery
