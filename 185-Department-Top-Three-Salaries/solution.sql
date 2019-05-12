# Write your MySQL query statement below
SELECT d.Name Department, e.Name Employee, e.Salary Salary
FROM Employee e JOIN Department d ON e.DepartmentId=d.Id
WHERE
(SELECT COUNT(DISTINCT Salary)
 FROM Employee t
 WHERE t.Salary > e.Salary AND t.DepartmentId = e.DepartmentId) < 3
Order BY d.Id ASC, e.Salary DESC, e.Name ASC