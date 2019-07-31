# Write your MySQL query statement below

SELECT ROUND(IFNULL(SUM(t.sessions) / COUNT(t.user_id), 0), 2) average_sessions_per_user
FROM (
    SELECT user_id, COUNT(DISTINCT session_id) sessions
    FROM Activity
    WHERE activity_date BETWEEN '2019-07-27' - INTERVAL 29 DAY AND '2019-07-27'
    GROUP BY user_id
) t
