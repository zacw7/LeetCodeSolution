# Write your MySQL query statement below
SELECT MIN(ROUND(SQRT(POW(t1.x - t2.x, 2) + POW(t1.y - t2.y, 2)), 2)) shortest
FROM point_2d t1, point_2d t2
WHERE t1.x <> t2.x
OR t1.y <> t2.y