# Write your MySQL query statement below
SELECT login_date, COUNT(1) user_count
FROM (
    SELECT MIN(activity_date) login_date, user_id
    FROM Traffic
    WHERE activity='login'
    GROUP BY user_id
) t
WHERE login_date BETWEEN '2019-06-30' - INTERVAL 90 DAY AND '2019-06-30'
GROUP BY login_date