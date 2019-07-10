# Write your MySQL query statement below
SELECT project_id
FROM Project
GROUP BY project_id
HAVING count(1) = (
    SELECT count(1) employee_count
    FROM Project
    GROUP BY project_id
    ORDER BY employee_count DESC
    LIMIT 1
    )