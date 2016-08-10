# Write your MySQL query statement below
SELECT Name as Customers
FROM Customers
WHERE Id IN (SELECT DISTINCT(CustomersId) FROM Orders)