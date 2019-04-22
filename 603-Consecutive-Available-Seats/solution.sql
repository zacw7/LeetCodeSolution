# Write your MySQL query statement below
SELECT seat_id
FROM cinema p1
WHERE EXISTS (
    SELECT 1 FROM cinema p2
    WHERE p2.free=1
      AND ABS(p1.seat_id-p2.seat_id)=1
)
AND p1.free=1