# Write your MySQL query statement below
select *
from
    (select *
     from Employee
     order by salary) A
where rownum = 2