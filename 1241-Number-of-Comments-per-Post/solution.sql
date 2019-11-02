# Write your MySQL query statement below

SELECT t1.post_id, COUNT(DISTINCT t2.sub_id) number_of_comments
FROM (
    SELECT sub_id post_id
    FROM Submissions
    WHERE parent_id IS null
) t1
LEFT JOIN Submissions t2
ON t1.post_id = t2.parent_id
GROUP BY t1.post_id
