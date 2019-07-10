# Write your MySQL query statement below

SELECT t1.project_id, t1.employee_id
FROM (
    SELECT p1.project_id, e1.employee_id, e1.experience_years
    FROM Project p1 JOIN Employee e1 ON p1.employee_id=e1.employee_id
) t1
JOIN (
    SELECT p2.project_id, MAX(e2.experience_years) max_exp
    FROM Project p2 JOIN Employee e2 ON p2.employee_id=e2.employee_id
    GROUP BY p2.project_id
) t2
ON t1.project_id=t2.project_id
WHERE t1.experience_years=t2.max_exp