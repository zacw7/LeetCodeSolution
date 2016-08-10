# Write your MySQL query statement below
SELECT Name as Customers
FROM Customers
WHERE Id NOT IN (SELECT DISTINCT(CustomerId) FROM Orders);