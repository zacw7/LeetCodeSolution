# Write your MySQL query statement below

SELECT customer_id
FROM Customer c JOIN Product p ON p.product_key = c.product_key
GROUP BY customer_id
HAVING COUNT(DISTINCT c.product_key) = (SELECT COUNT(1) FROM Product)