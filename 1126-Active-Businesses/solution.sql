# Write your MySQL query statement below

SELECT business_id
FROM (
    SELECT business_id, event_type, SUM(occurences) occ
    FROM Events
    GROUP BY business_id, event_type
) t1
JOIN (
    SELECT AVG(occurences) average, event_type
    FROM Events
    GROUP BY event_type
) t2
ON t1.event_type = t2.event_type AND t1.occ > t2.average
GROUP BY business_id
HAVING COUNT(1) > 1