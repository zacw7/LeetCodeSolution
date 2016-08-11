# Write your MySQL query statement below
SELECT Score, (SELECT count(DISTINCT(Score)) FROM Scores WHERE Score>=S.Score) AS Rank
FROM Scores AS S
ORDER BY Score DESC