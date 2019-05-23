# 571. Find Median Given Frequency of Numbers

**Hard**

[Original Page](https://leetcode.com/problems/find-median-given-frequency-of-numbers/)

SQL Schema >
```
Create table If Not Exists Numbers (Number int, Frequency int)
Truncate table Numbers
insert into Numbers (Number, Frequency) values ('0', '7')
insert into Numbers (Number, Frequency) values ('1', '1')
insert into Numbers (Number, Frequency) values ('2', '3')
insert into Numbers (Number, Frequency) values ('3', '1')
```

The `Numbers` table keeps the value of number and its frequency.
```
+----------+-------------+
|  Number  |  Frequency  |
+----------+-------------|
|  0       |  7          |
|  1       |  1          |
|  2       |  3          |
|  3       |  1          |
+----------+-------------+
```

In this table, the numbers are `0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3`, so the median is `(0 + 0) / 2 = 0`.
```
+--------+
| median |
+--------|
| 0.0000 |
+--------+
```

Write a query to find the median of all numbers and name the result as `median`.
