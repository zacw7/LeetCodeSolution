# Write your MySQL query statement below
SELECT Email
FROM 	(SELECT COUNT(Id) AS C, Email
		FROM Person
		GROUP BY Email) AS P
WHERE C>1