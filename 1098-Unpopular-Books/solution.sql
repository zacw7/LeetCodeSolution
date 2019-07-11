# Write your MySQL query statement below

SELECT b.book_id, b.name
FROM Books b
LEFT JOIN (
    SELECT book_id, SUM(quantity) sold
    FROM Orders
    WHERE dispatch_date >= '2019-06-23' - INTERVAL 1 YEAR
    GROUP BY book_id
) o
ON b.book_id=o.book_id
WHERE b.available_from <= '2019-06-23' - INTERVAL 1 MONTH
  AND IFNULL(o.sold, 0) < 10