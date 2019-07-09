# Write your MySQL query statement below
SELECT e.student_id, MIN(e.course_id) course_id, e.grade
FROM Enrollments e
JOIN (
    SELECT student_id, MAX(grade) grade
    FROM Enrollments
    GROUP BY student_id
) m
ON e.student_id=m.student_id AND e.grade=m.grade
GROUP BY e.student_id, e.grade
ORDER BY e.student_id