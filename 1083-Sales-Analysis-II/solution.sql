# Write your MySQL query statement below
SELECT DISTINCT buyer_id
FROM Sales
WHERE buyer_id IN (
    SELECT buyer_id
    FROM Sales s JOIN Product p ON s.product_id=p.product_id
    WHERE p.product_name='S8'
)
AND buyer_id NOT IN (
    SELECT buyer_id
    FROM Sales s JOIN Product p ON s.product_id=p.product_id
    WHERE p.product_name='iPhone'
)