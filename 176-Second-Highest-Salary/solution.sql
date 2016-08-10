# Write your MySQL query statement below
SELECT distinct(Salary) AS SecondHighestSalary
FROM Employee
ORDER BY SecondHighestSalary
LIMIT 1,1;

SELECT distinct(Salary) as SecondHighestSalary FROM Employee UNION SELECT NULL ORDER BY SecondHighestSalary DESC LIMIT 1,1;