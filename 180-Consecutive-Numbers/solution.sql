# Write your MySQL query statement below
select distinct Num ConsecutiveNums
from Logs t1
where exists(
    select 1 from Logs t2 where t1.Num=t2.Num and t2.Id=t1.Id+1
)
and exists(
    select 1 from Logs t3 where t1.Num=t3.Num and t3.Id=t1.Id+2
)