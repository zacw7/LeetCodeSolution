# Write your MySQL query statement below
SELECT
t1.follower follower,
COUNT(DISTINCT t2.follower) num
FROM follow t1 JOIN follow t2 on t1.follower = t2.followee
GROUP BY t1.follower
ORDER BY t1.follower