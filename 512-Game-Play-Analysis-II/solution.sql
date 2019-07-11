# Write your MySQL query statement below

SELECT a.player_id, a.device_id
FROM Activity a
JOIN (
    SELECT player_id, MIN(event_date) first_login
    FROM Activity
    GROUP BY player_id
) b
ON a.player_id=b.player_id
WHERE a.event_date=b.first_login
