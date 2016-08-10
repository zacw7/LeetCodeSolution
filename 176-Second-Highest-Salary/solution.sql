# Write your MySQL query statement below
SELECT DISTINCT(Salary) AS SecondHighestSalary
FROM Employee
UNION SELECT NULL
ORDER BY SecondHighestSalary
LIMIT 1,1;