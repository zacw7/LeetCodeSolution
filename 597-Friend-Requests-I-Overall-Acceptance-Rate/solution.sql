# Write your MySQL query statement below
select case when c1.cnt=0 then 0.0 else Round(c2.cnt / c1.cnt, 2) end as accept_rate
from (select count(distinct sender_id, send_to_id) cnt from friend_request) c1,
(select count(distinct requester_id, accepter_id) cnt from request_accepted) c2