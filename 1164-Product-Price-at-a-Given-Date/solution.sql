# Write your MySQL query statement below

SELECT m.product_id, IFNULL(b.new_price, 10) price
FROM (
    SELECT DISTINCT product_id FROM Products
) m
LEFT JOIN (
    SELECT product_id, MAX(change_date) last_update_date
    FROM Products
    WHERE change_date <= '2019-08-16'
    GROUP BY product_id
) a
ON m.product_id = a.product_id
LEFT JOIN Products b
ON a.product_id = b.product_id AND a.last_update_date = b.change_date
