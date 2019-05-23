# Write your MySQL query statement below
SELECT
t1.id id,
IF(t1.p_id IS NULL, "Root", IF(t2.children IS NULL, "Leaf", "Inner")) Type
FROM tree t1
LEFT JOIN (
    SELECT p_id, COUNT(1) children FROM tree GROUP BY p_id
) t2
ON t1.id = t2.p_id