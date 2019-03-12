# Write your MySQL query statement below
SELECT t.class
FROM (
    SELECT class, count(distinct student) as students
    FROM courses
    GROUP BY class
) t
WHERE t.students>=5