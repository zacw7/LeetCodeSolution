# 1050. Actors and Directors Who Cooperated At Least Three Times

**Medium**

[Original Page](https://leetcode.com/problems/actors-and-directors-who-cooperated-at-least-three-times/)

SQL Schema >
```
Create table If Not Exists ActorDirector (actor_id int, director_id int, timestamp int)
Truncate table ActorDirector
insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '0')
insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '1')
insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '1', '2')
insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '2', '3')
insert into ActorDirector (actor_id, director_id, timestamp) values ('1', '2', '4')
insert into ActorDirector (actor_id, director_id, timestamp) values ('2', '1', '5')
insert into ActorDirector (actor_id, director_id, timestamp) values ('2', '1', '6')
```

Table: `ActorDirector`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| actor_id    | int     |
| director_id | int     |
| timestamp   | int     |
+-------------+---------+
timestamp is the primary key column for this table.
```

Write a SQL query for a report that provides the pairs `(actor_id, director_id)` where the actor have cooperated with the director at least 3 times.

##### Example:
```
ActorDirector table:
+-------------+-------------+-------------+
| actor_id    | director_id | timestamp   |
+-------------+-------------+-------------+
| 1           | 1           | 0           |
| 1           | 1           | 1           |
| 1           | 1           | 2           |
| 1           | 2           | 3           |
| 1           | 2           | 4           |
| 2           | 1           | 5           |
| 2           | 1           | 6           |
+-------------+-------------+-------------+

Result table:
+-------------+-------------+
| actor_id    | director_id |
+-------------+-------------+
| 1           | 1           |
+-------------+-------------+
The only pair is (1, 1) where they cooperated exactly 3 times.
```
