# Write your MySQL query statement below
SELECT
d.dept_name dept_name,
IF(student_id IS NULL, 0, COUNT(1)) student_number
FROM department d LEFT JOIN student s ON d.dept_id=s.dept_id
GROUP BY d.dept_id
ORDER BY student_number desc, d.dept_name