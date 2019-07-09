# Write your MySQL query statement below
SELECT p.product_id, p.product_name
FROM Sales s JOIN Product p ON s.product_id=p.product_id
GROUP BY p.product_id
HAVING SUM(IF(sale_date BETWEEN '2019-01-01' AND '2019-03-31', 1, 0)) > 0
AND SUM(IF(sale_date BETWEEN '2019-01-01' AND '2019-03-31', 0, 1)) = 0