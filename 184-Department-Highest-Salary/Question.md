# 184. Department Highest Salary

[Original Page](https://leetcode.com/problems/department-highest-salary/)

The `Employee` table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

<pre>+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
</pre>

The `Department` table holds all departments of the company.

<pre>+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
</pre>

Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

<pre>+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
</pre>

<div>

[Subscribe](/subscribe/) to see which companies asked this question

</div>