# Write your MySQL query statement below

SELECT
    a.install_dt,
    COUNT(DISTINCT a.player_id) installs,
    ROUND(IFNULL(COUNT(DISTINCT b.player_id) / COUNT(DISTINCT a.player_id), 0), 2) Day1_retention
FROM (
    SELECT player_id, MIN(event_date) install_dt, MIN(event_date) + INTERVAL 1 DAY retention_dt
    FROM Activity
    GROUP BY player_id
) a
LEFT JOIN Activity b
ON a.player_id = b.player_id AND a.retention_dt = b.event_date
GROUP BY a.install_dt
