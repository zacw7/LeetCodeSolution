# Write your MySQL query statement below

SELECT c.Name
FROM Candidate c
JOIN (
    SELECT CandidateId
    FROM Vote
    GROUP BY CandidateId
    ORDER BY COUNT(id) DESC
    LIMIT 1
) w
ON c.id=w.CandidateId