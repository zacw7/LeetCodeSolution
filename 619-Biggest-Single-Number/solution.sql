# Write your MySQL query statement below
select max(t.num) num
from (
    select num, count(num) c
    from my_numbers
    group by num
) t
where c = 1