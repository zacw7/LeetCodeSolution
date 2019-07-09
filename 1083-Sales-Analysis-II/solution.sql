# Write your MySQL query statement below
SELECT buyer_id
FROM Sales s JOIN Product p ON s.product_id=p.product_id
GROUP BY buyer_id
HAVING SUM(CASE WHEN product_name='S8' THEN 1 ELSE 0 END) > 0
AND SUM(CASE WHEN product_name='iPhone' THEN 1 ELSE 0 END) = 0
