# Write your MySQL query statement below
SELECT R.Name AS Employee
FROM (SELECT Emp.Name AS Name
			 FROM Employee AS Emp, Employee AS Mgr
			 WHERE Emp.ManagerId=Mgr.Id AND Emp.Salary>Mgr.Salary)
			 AS R