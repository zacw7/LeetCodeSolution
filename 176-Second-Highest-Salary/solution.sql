# Write your MySQL query statement below
select *
from
    (select *
     from Employee
     order by salary)
where rownum = 2