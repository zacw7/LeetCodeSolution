# Write your MySQL query statement below
SELECT
IF(MOD(COUNT(1), 2) = 0, SUM(n.number) / 2, SUM(n.number)) median
FROM (
    SELECT
    t.Number number,
    (SELECT SUM(t1.Frequency) FROM Numbers t1 WHERE t1.Number <= t.Number) first_half,
    (SELECT SUM(t1.Frequency) FROM Numbers t1 WHERE t1.Number >= t.Number) second_half
    FROM Numbers t
) n,
(
    SELECT SUM(Frequency) total FROM Numbers
) c
WHERE
(n.first_half > c.total / 2 AND n.second_half > c.total / 2)
OR (MOD(c.total, 2) = 0 AND n.first_half >= c.total / 2 AND n.second_half >= c.total / 2)
