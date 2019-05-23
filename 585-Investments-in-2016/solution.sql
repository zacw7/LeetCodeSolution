# Write your MySQL query statement below
SELECT
SUM(t.TIV_2016) TIV_2016
FROM insurance t
WHERE
NOT EXISTS (
    SELECT 1
    FROM insurance m1
    WHERE t.PID <> m1.PID
    AND t.LAT = m1.LAT
    AND t.LON = m1.LON
)
AND
EXISTS (
    SELECT 1
    FROM insurance m2
    WHERE t.PID <> m2.PID
    AND t.TIV_2015 = m2.TIV_2015
)