# Write your MySQL query statement below
SELECT Now.Id
FROM Weather AS Now, Weather AS Pre
WHERE date_sub(Now.Date,interval 1 day)=Pre.Date AND Now.Temperature>Pre.Temperature