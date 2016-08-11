# Write your MySQL query statement below
SELECT Person.FirstName, Person.LastName, Address.City, Address.State
FROM Person Left Join Address ON Person.PersonId=Address.PersonId;