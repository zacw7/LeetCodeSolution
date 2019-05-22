# Write your MySQL query statement below
SELECT
t1.id id,
CASE MOD(t1.id, 2)
WHEN 0 THEN t2.student
ELSE IF(t3.student IS NULL, t1.student, t3.student)
END student
FROM seat t1
LEFT JOIN seat t2 ON t1.id = t2.id + 1
LEFT JOIN seat t3 ON t1.id = t3.id - 1
