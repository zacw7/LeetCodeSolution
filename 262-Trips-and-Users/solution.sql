# Write your MySQL query statement below
SELECT Request_at Day, ROUND(SUM(IF(Status<>'completed', 1, 0))/COUNT(1), 2) 'Cancellation Rate'
FROM Trips
WHERE Client_Id NOT IN (SELECT Users_Id FROM Users WHERE Role='client' AND Banned='Yes')
  AND Driver_Id NOT IN (SELECT Users_Id FROM Users WHERE Role='driver' AND Banned='Yes')
  AND Request_at BETWEEN '2013-10-01' AND '2013-10-03'
GROUP BY Request_at
ORDER BY Request_at