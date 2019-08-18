# Write your MySQL query statement below

SELECT u.user_id buyer_id, MIN(u.join_date) join_date, COUNT(o.order_id) orders_in_2019
FROM Users u
LEFT JOIN (SELECT order_id, buyer_id FROM Orders WHERE order_date BETWEEN '2019-01-01' AND '2019-12-31') o
ON u.user_id=o.buyer_id
GROUP BY u.user_id
ORDER BY u.user_id
